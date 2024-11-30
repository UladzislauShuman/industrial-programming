package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame
        extends JFrame
        implements Subject
{
    private List<Observer> observerList = new ArrayList<>();

    private KeyLogger keyLogger;
    private KeyBoard keyBoard;

    public MyFrame()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2));

        this.keyBoard = new KeyBoard();
        this.keyLogger = new KeyLogger();

        this.add(this.keyBoard);
        this.add(this.keyLogger);

        this.attach(this.keyBoard);
        this.attach(this.keyLogger);

        this.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            public void windowGainedFocus(java.awt.event.WindowEvent e) {
                MyFrame.this.requestFocusInWindow();
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String key = String.valueOf(e.getKeyChar());
                System.out.println("here");
                notifyObservers(key);
            }
        });

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    @Override
    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String key) {
        for(Observer observer : this.observerList)
        {
            observer.update(key);
        }
    }
}
