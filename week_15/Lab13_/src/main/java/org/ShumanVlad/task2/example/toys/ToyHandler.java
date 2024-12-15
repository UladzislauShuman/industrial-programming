package org.ShumanVlad.task2.example.toys;

import java.util.ArrayList;
import java.util.List;

public class ToyHandler extends org.xml.sax.helpers.DefaultHandler {
    private List<Toy> toys;
    private Toy currentToy;
    private String currentElement;

    public ToyHandler() {
        toys = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        currentElement = localName;
        if (localName.equals("toy")) {
            currentToy = new Toy();
            currentToy.setName(attributes.getValue("name"));
            currentToy.setPrice(Integer.parseInt(attributes.getValue("price")));
            currentToy.setFromAge(Integer.parseInt(attributes.getValue("fromAge")));
            currentToy.setToAge(Integer.parseInt(attributes.getValue("toAge")));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        String text = new String(ch, start, length).trim();
        if (currentToy != null) {
            switch (currentElement) {
                case "name": currentToy.setName(text); break;
                case "price": currentToy.setPrice(Integer.parseInt(text)); break;
                case "fromAge": currentToy.setFromAge(Integer.parseInt(text)); break;
                case "toAge": currentToy.setToAge(Integer.parseInt(text)); break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (localName.equals("toy")) {
            toys.add(currentToy);
            currentToy = null;
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}