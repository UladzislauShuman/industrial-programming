package org.ShumanVlad.task2.example.toys;

import org.ShumanVlad.task2.example.strategy.agelist.AgeListStrategy;
import org.ShumanVlad.task2.example.strategy.builder.BuilderStrategy;
import org.ShumanVlad.task2.example.strategy.sort.SortStrategy;
import org.ShumanVlad.task2.example.strategy.sort.StreamPriceSortStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "toys")
@XmlAccessorType(XmlAccessType.FIELD)
public class Toys
{
    @XmlElement(name = "toy")
    private ArrayList<Toy> toys;

    public Toys() throws Exception
    {
        this.toys = new ArrayList<Toy>();
    }
    public Toys(List<Toy> toys) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        this.toys.addAll(toys);
    }
    private Toys(Toys toys) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        this.toys.addAll(toys.toys);
    }
    public Toys(String fileName) throws Exception
    {
        this.toys = new ArrayList<Toy>();
        CheckData.checkToysData(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null)
        {
            Toy tempToy = new Toy(line);
            this.toys.add(tempToy);
        }
    }


    public Toys add(Toy toy) throws Exception {
        this.toys.add(toy);
        return this;
    }
    public int size() throws Exception {return this.toys.size();}
    public Toy get(int i) throws Exception {return this.toys.get(i);}

    public Toys getToysForThisAge(int age, AgeListStrategy strategy) throws Exception
    {
        return strategy.getToysForThisAge(this, age);
    }

    public Toys sortWithStrategy(SortStrategy strategy) throws Exception
    {
        return strategy.sort(this);
    }

    public Toys sortByPrice() throws Exception
    {
        return this.sortWithStrategy(new StreamPriceSortStrategy());
    }

    public Toys sortByPrice(int maxPrice) throws Exception
    {
        this.sortByPrice();

        int left = 0;
        int right = this.size() - 1;
        int lastIndex = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int price = this.get(mid).getPrice();

            if (price <= maxPrice) {
                lastIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        Toys toys = new Toys();
        for (int i = 0; i <= lastIndex; ++i)
        {
            toys.add(this.toys.get(i));
        }
        return toys;
    }
    /*
    Построить различные списки игрушек для заданного возраста,
    суммарная стоимость которых не превосходит заданную величину.
    */
    public String toStringLists(int age, int price, BuilderStrategy builderStrategy) throws Exception
    {
        return ListsBuilder.toStringLists(this, age, price, builderStrategy);
    }

    @Override
    public String toString()
    {
        String result = "";
        for (Toy toy : this.toys)
            result += toy.toString() + "\n";
        return result;
    }

    public ArrayList<Toy> getToys() {return this.toys;}

    public void loadFromXMLSAX(String filename) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ToyHandler handler = new ToyHandler();
        parser.parse(filename, handler);
        this.toys = (ArrayList<Toy>) handler.getToys();
    }

    public void loadFromXMLStAX(String filename) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filename));
        this.toys = new ArrayList<>();
        boolean inToys = false;

        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if ("toys".equals(reader.getLocalName())) {
                    inToys = true;
                } else if ("toy".equals(reader.getLocalName()) && inToys) {
                    Toy toy = new Toy();
                    String name = reader.getAttributeValue(null, "name");
                    String priceStr = reader.getAttributeValue(null, "price");
                    String fromAgeStr = reader.getAttributeValue(null, "fromAge");
                    String toAgeStr = reader.getAttributeValue(null, "toAge");

                    try {
                        toy.setName(name);
                        toy.setPrice(Integer.parseInt(priceStr));
                        toy.setFromAge(Integer.parseInt(fromAgeStr));
                        toy.setToAge(Integer.parseInt(toAgeStr));
                        this.toys.add(toy);
                    } catch (NumberFormatException e) {
                        System.err.println("Warning: Skipping toy element due to invalid number format: " + e.getMessage());
                    }
                }
            } else if (event == XMLStreamConstants.END_ELEMENT && "toys".equals(reader.getLocalName())) {
                inToys = false;
            }
        }
        reader.close();
    }

    public void loadFromXMLDOM(String filename) throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));

            this.toys = new ArrayList<>();
            NodeList toyNodes = document.getElementsByTagName("toy");

            for (int i = 0; i < toyNodes.getLength(); i++) {
                Node toyNode = toyNodes.item(i);
                if (toyNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element toyElement = (Element) toyNode;
                    Toy toy = new Toy();
                    toy.setName(toyElement.getAttribute("name"));
                    toy.setPrice(Integer.parseInt(toyElement.getAttribute("price")));
                    toy.setFromAge(Integer.parseInt(toyElement.getAttribute("fromAge")));
                    toy.setToAge(Integer.parseInt(toyElement.getAttribute("toAge")));
                    this.toys.add(toy);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error parsing XML file using DOM: " + e.getMessage());
        }
    }

    public void saveToXML(String filename) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Toys.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, new File(filename));
    }


}
