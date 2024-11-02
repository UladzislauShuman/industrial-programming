package org.ShumanVlad.task2.elements.buttonspanel.button;

import org.ShumanVlad.task2.StudentSurvey;
import org.ShumanVlad.task2.elements.buttonspanel.ButtonPanel;

import javax.swing.*;

public class GreenButton extends JButton
{
    private ButtonPanel buttonPanel;
    public GreenButton(ButtonPanel buttonPanel)
    {
        super("Да");
        this.buttonPanel = buttonPanel;
        this.addActionListener(e -> JOptionPane.showMessageDialog(this.buttonPanel, "Мы рады)"));
    }
}
