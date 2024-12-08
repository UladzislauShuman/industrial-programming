package mvc.controller;

import mvc.model.MapModel;
import mvc.view.MapView;
import mydatastructure.map.ShumanPair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapController<KeyType, ValueType> {
    private MapModel<KeyType, ValueType> model;
    private MapView<KeyType, ValueType> view;

    public MapController(MapModel<KeyType, ValueType> model, MapView<KeyType, ValueType> view) {
        this.model = model;
        this.view = view;

        // Установка модели списка задач
        view.setListModel(model.getMapListModel());

        // Добавление слушателей к кнопкам
        view.addAddButtonListener(new AddButtonListener());
        view.addRemoveButtonListener(new RemoveButtonListener());
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShumanPair<KeyType, ValueType> newPair = view.getNewPairInput();
            if (newPair != null) {
                model.addPair(newPair);
                view.setListModel(model.getMapListModel());
            }
        }
    }

    class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShumanPair<KeyType, ValueType> selectedPair = view.getSelectedPair();
            if (selectedPair != null) {
                model.removePair(selectedPair);
                view.setListModel(model.getMapListModel());
            }
        }
    }
}
