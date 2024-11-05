package org.ShumanVlad;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class MyFrame extends JFrame
{
    private List<Toy> toys;
    private List<Toy> sortedToys;
    private List<Toy> filteredToys;

    JTextArea text;
    JTextArea sortedText;
    JTextArea filteredText;

    public MyFrame(
            List<Toy> toys,
            List<Toy> sortedToys,
            List<Toy> filteredToys)
    {
        this.toys = toys;
        this.sortedToys = sortedToys;
        this.filteredToys = filteredToys;

        this.setSize(800, 600);

        this.setTitle("SelfWork10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(1, 3));

        this.text = new JTextArea();
        this.text.setBorder(BorderFactory.createLineBorder(Color.white));
        this.text.setText(
                ToyUtil.writeToString(
                        this.toys
                )
        );
        this.text.setEditable(false);
        this.add(this.text);

        this.sortedText = new JTextArea();
        this.sortedText.setBorder(BorderFactory.createLineBorder(Color.red));
        this.sortedText.setText(
                ToyUtil.writeToString(
                        this.sortedToys
                )
        );
        this.sortedText.setEditable(false);
        this.add(this.sortedText);

        this.filteredText = new JTextArea();
        this.filteredText.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.filteredText.setText(
                ToyUtil.writeToString(
                        this.filteredToys
                )
        );
        this.filteredText.setEditable(false);
        this.add(this.filteredText);
        this.setVisible(true);
    }

}
