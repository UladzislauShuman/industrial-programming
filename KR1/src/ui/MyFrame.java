package ui;

import cars.Car;
import ui.buttons.OpenDialogButton;
import ui.panels.ButtonsPanel;
import ui.panels.ListPanel;
import ui.panels.SortListPanel;
import util.Util;

import javax.swing.*;
import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
В оконном swing приложении
(более предпочтительный вариант, но допустим и консольный вариант)
реализовать команды для открытия и вывода файлов первого и файлов второго вариантов
(предпочтительнее через компоненту файлового диалога) в оконную компоненту №1.

Команды обработки данных выводят результат в оконную компоненту №2 (перед каждым выводом чистите ее).

Для пятого метода предусмотреть компоненту №3.
 */
public class MyFrame
        extends JFrame
{
    private ListPanel<Car> panel1;
    private SortListPanel panel2;
    private ListPanel<String> panel3;
    private List<Car> cars;

    private ButtonsPanel buttonsPanel;

    public MyFrame()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.cars = new ArrayList<>();
        this.panel1 = new ListPanel<>(); this.add(this.panel1, BorderLayout.WEST);
        this.panel2 = new SortListPanel(); this.add(this.panel2, BorderLayout.CENTER);
        this.panel3 = new ListPanel<>(); this.add(this.panel3, BorderLayout.EAST);

        this.buttonsPanel = new ButtonsPanel(this);
        this.add(this.buttonsPanel, BorderLayout.NORTH);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public void updateFrame(String filePath)
    {
        this.cars = Util.readCars(filePath);
        this.panel1.setList(cars);
        this.panel2.setList(cars);
        this.panel3.setList(Util.getCarsByStartingWithT(cars));
    }

    public void saveCarsInFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();
        for (Car car : this.cars)
        {
            sb.append(car.toString()).append("\n");
        }

        try(FileWriter writer = new FileWriter(filePath))
        {
            writer.write(sb.toString());
        }
        catch (IOException e)
        {
            System.out.println();
        }
    }
}
