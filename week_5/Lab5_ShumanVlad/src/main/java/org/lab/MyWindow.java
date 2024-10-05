package org.lab;

import elements.TypeBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Реализовать оконное приложение с удобным интерфейсом (выбор прогрессии, выбор имени файла и т.п.),
//в т.ч. отображения на окне первых n элементов.

public class MyWindow extends JFrame
{
    private JTextField fileNameField;
    private JTextField nField;
    private JTextField aField;
    private JTextField dField;
    private JTextArea resultArea;
    private JButton calculateButton;
    private JComboBox<String> typeBox;

    public MyWindow()
    {
        this.setSize(400, 300);
        this.setTitle("Series");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());

        this.fileNameField = new JTextField(15);
        this.addElement("FileName: ", this.fileNameField);

        this.aField = new JTextField(15);
        this.addElement("A: ", this.aField);

        this.dField = new JTextField(15);
        this.addElement("D: ", this.dField);

        this.nField = new JTextField(15);
        this.addElement("N: ", this.nField);

        this.typeBox = new TypeBox();
        this.addElement("Setie: ", this.typeBox);

        this.calculateButton = new JButton("Calculate");
        this.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                calculate();
            }
        });
        this.add(this.calculateButton);

        this.resultArea = new JTextArea(10, 30);
        this.resultArea.setEditable(false);
        this.addElement("Result: ", new JScrollPane(this.resultArea));

        this.setLocationRelativeTo(null);
    }

    private void calculate()
    {
        try
        {
            if (this.isEmptyTextEdits())
                throw new Exception("Empty TextEdit");

            Series serie = this.getSerie();

            this.setResultArea(serie);
            this.saveFile(
                    serie,
                    this.fileNameField.getText()
                    );
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



    private void addElement(String elementName, Component element)
    {
        this.add(new JLabel(elementName));
        this.add(element);
    }

    private Series getSerie() throws Exception
    {
        Object currentType = this.typeBox.getSelectedItem();
        if (currentType.equals("Liner"))
        {
            return new Liner(
                    Double.parseDouble(this.aField.getText()),
                    Double.parseDouble(this.dField.getText())
            );
        }
        else if(currentType.equals("Exponential"))
        {
            return new Exponential(
                    Double.parseDouble(this.aField.getText()),
                    Double.parseDouble(this.dField.getText())
            );
        }
        else
        {
            throw new Exception("No type of Serie");
        }
    }

    private int getN() throws Exception
    {
        int n = Integer.parseInt(this.nField.getText());
        if (n < 1)
            throw new Exception("n < 1");
        return n;
    }

    private boolean isEmptyTextEdits()
    {
        return  this.aField.getText().isEmpty() ||
                this.dField.getText().isEmpty() ||
                this.nField.getText().isEmpty() ||
                this.fileNameField.getText().isEmpty();
    }

    private void setResultArea(Series serie) throws Exception
    {
        this.resultArea.setText(
                serie.toString(
                        1,
                        this.getN()
                )
        );
    }

    private boolean saveFile(Series serie, String fileName) throws Exception
    {
        if (this.checkFileName(fileName))
        {
            serie.saveFile(
                    fileName,
                    Integer.parseInt(this.nField.getText())
            );
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean checkFileName(String fileName) throws Exception
    {
        if (!fileName.endsWith(".txt")) {
            throw new Exception("is not txt-file");
        }
        return true;
    }

}

