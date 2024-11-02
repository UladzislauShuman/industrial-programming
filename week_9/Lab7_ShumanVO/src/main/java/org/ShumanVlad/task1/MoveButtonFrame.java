package org.ShumanVlad.task1;

import javax.swing.*;
import java.awt.event.*;

/*
    1. Реализовать приложение, обладающее следующей функциональностью:
    • в окне есть одна кнопка;
    • координаты мыши отображаются в строке состояния, находящейся внизу окна;
    • щелчок мышью отображает кнопку в позиции щелчка;
    • возможен drag&drop кнопки с нажатым Ctrl; (обращать внимание, что координаты мыши в строке состояния должны также изменяться вне зависимости от нажатия Ctrl)
    • возможно добавление символов в текст кнопки, а также посредством Backspace удалять последний символ.
 */
public class MoveButtonFrame extends JFrame
{
    private JButton button;
    private JLabel status;

    public MoveButtonFrame()
    {
        setTitle("MouseButton");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        button = new JButton("Button");
        button.setBounds(250, 150, 100, 50);
        add(button);

        status = new JLabel("Coordinates: ");
        status.setBounds(0, 0, 200, 20);
        add(status);

        this.setUpdateState(true);
        this.setMoveButtom(true);
        this.setBackspace(true);
        this.setCtrl(true);

        this.setVisible(true);
    }


    private void setUpdateState(Boolean state)
    {
        if(state){
            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    updateStatus(e);
                }
            });
        }
        else{
            this.addMouseMotionListener(null);
        }
    }
    private void updateStatus(MouseEvent e) {
        status.setText(String.format("Mouse Coordinates: (%d, %d)", e.getX(), e.getY()));
    }

    private void setMoveButtom(Boolean state)
    {
        if(state)
        {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button.setLocation(e.getX(), e.getY());
                }
            });
        }
        else{
            this.addMouseListener(null);
        }
    }

    private void setBackspace(Boolean state)
    {
        if(state)
        {
            this.button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (Character.isLetterOrDigit(c)) {
                        button.setText(button.getText() + c);
                    } else if (c == KeyEvent.VK_BACK_SPACE && button.getText().length() > 0) {
                        button.setText(button.getText().substring(0, button.getText().length() - 1));
                    }
                }
            });
        }
        else{
            this.button.addKeyListener(null);
        }
    }

    private void setCtrl(Boolean state)
    {
        if(state)
        {
            this.button.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (e.isControlDown()) {
                        button.setLocation(button.getX() + e.getX(), button.getY() + e.getY());
                    }
                }
            });
        }
        else{
            this.button.addMouseMotionListener(null);
        }
    }
}

