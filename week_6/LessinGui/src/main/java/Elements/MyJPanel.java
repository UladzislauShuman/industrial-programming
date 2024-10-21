package Elements;

import Humans.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJPanel extends JPanel
{
    private Student student;

    public MyJPanel(Student student)
    {
        this.student = student;
        this.setLayout(new GridLayout(2,1));
        JTextField textField = new JTextField(student.toString());
        textField.setFont(new Font("Courier", Font.BOLD | Font.ITALIC, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);

        JButton buttonChange = new JButton("Change");
        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.setAge(student.getAge() + 1);
                textField.setText(student.toString());
            }
        });
        this.add(textField);
        this.add(buttonChange);
    }
}
