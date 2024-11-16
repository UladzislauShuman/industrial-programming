package ShumanVlad.ui.pages.page2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonMouseListener implements MouseListener
{
    private Color color;
    private String text;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        JButton button = (JButton) e.getSource();
        this.text = button.getText();
        button.setText("Clicked");
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        JButton button = (JButton) e.getSource();
        button.setText(this.text);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        JButton button = (JButton) e.getSource();
        this.color = button.getBackground();
        button.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        JButton button = (JButton) e.getSource();
        button.setBackground(this.color);
    }
}
