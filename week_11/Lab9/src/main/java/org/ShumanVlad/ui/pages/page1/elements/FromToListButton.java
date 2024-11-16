package org.ShumanVlad.ui.pages.page1.elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FromToListButton<T> extends JButton
{
    public FromToListButton(
            String title,
            ListPanel<T> from,
            ListPanel<T> to
    )
    {
        super(title);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<T> leftSelected = from.getList().getSelectedValuesList();
                to.getListModel().addAll(
                        leftSelected
                );
                for (T item : leftSelected){
                    from.getListModel().removeElement(item);
                }
            }
        });
    }
}
