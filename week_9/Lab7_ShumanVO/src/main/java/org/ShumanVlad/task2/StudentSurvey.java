package org.ShumanVlad.task2;

/*
    2. Реализовать приложение, обладающее следующей функциональностью:
    • в окне есть метка с вопросом о том, например,  радует ли размер стипендии, и две кнопки;
    • при щелчке по одной кнопке выводится некий «утешающий» ответ;
    • другая кнопка убегает при попытке наведения на нее, т.е. щелкнуть по ней невозможно.
 */
import org.ShumanVlad.task2.elements.buttonspanel.ButtonPanel;
import org.ShumanVlad.task2.elements.labels.QuestionLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class StudentSurvey extends JFrame
{
    private JButton greenButton;
    private JButton redButton;
    private ButtonPanel buttonPanel;
    private QuestionLabel question;

    public StudentSurvey()
    {
        this.setSize(400, 300);
        this.setTitle("Стипендия");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.question = new QuestionLabel();
        this.add(this.question, BorderLayout.NORTH);

        this.buttonPanel = new ButtonPanel(this);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}

