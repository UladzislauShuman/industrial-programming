package ui.panels;

import cars.Car;
import util.Util;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SortListPanel extends JPanel
{

    private ListPanel listPanel;
    private JComboBox comboBox;

    public SortListPanel()
    {
        super();
        this.setLayout(new BorderLayout());
        this.listPanel = new ListPanel();
        this.add(this.listPanel, BorderLayout.CENTER);

        String[] options =
                {
                        "Sort By Price And Rating",
                        "Sort By Price/Color Ratio"
                };

        this.comboBox = new JComboBox<>(options);
        this.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                List sortedCars;
                switch (selectedOption) {
                    case "Sort By Price And Rating":
                        sortedCars = Util.sortByPriceAndRating((List<Car>) listPanel.getListModel().elements());
                        break;
                    case "Sort By Price/Color Ratio":
                        sortedCars = Util.sortByPriceColorRatio((List<Car>) listPanel.getListModel().elements());
                        break;
                    default:
                        sortedCars = (List) listPanel.getListModel().elements();
                        break;
                }
                listPanel.setList(sortedCars);
            }
        });
        this.add(this.comboBox, BorderLayout.NORTH);
    }
    public void setList(List<Car> cars)
    {
        String selectedOption = (String) this.comboBox.getSelectedItem();
        switch (selectedOption) {
            case "Sort By Price And Rating":
                cars = Util.sortByPriceAndRating(cars);
                break;
            case "Sort By Price/Color Ratio":
                cars = Util.sortByPriceColorRatio(cars);
                break;
            default:
                break;
        }
        listPanel.setList(cars);
    }

}


