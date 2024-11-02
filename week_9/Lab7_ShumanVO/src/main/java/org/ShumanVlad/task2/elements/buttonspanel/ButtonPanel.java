package org.ShumanVlad.task2.elements.buttonspanel;


import org.ShumanVlad.task2.StudentSurvey;
import org.ShumanVlad.task2.elements.buttonspanel.button.GreenButton;
import org.ShumanVlad.task2.elements.buttonspanel.button.RedButton;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel
{
    private StudentSurvey studentSurvey;
    private GreenButton greenButton;
    private RedButton redButton;

    public ButtonPanel(StudentSurvey studentSurvey)
    {
        super();
        this.studentSurvey = studentSurvey;
        this.setLayout(new FlowLayout());

        this.greenButton = new GreenButton(this);
        this.add(greenButton);

        this.redButton = new RedButton(this);
        this.add(this.redButton);

    }

    public void add(JButton button)
    {
        super.add(button);
    }
}
