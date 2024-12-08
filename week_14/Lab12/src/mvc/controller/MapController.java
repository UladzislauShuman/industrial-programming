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

        this.view.setListModel(model.getListModel());
        this.addButtonListenersToButtons();
    }

    private void addButtonListenersToButtons()
    {
        this.view.addAddButtonListener(new AddButtonListener());
        this.view.addRemoveButtonListener(new RemoveButtonListener());
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShumanPair<KeyType, ValueType> newPair = view.getNewPairAddButton();
            if (newPair != null) {
                model.addElement(newPair);
                view.setListModel(model.getListModel());
            }
        }
    }

    class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShumanPair<KeyType, ValueType> selectedPair = view.getSelectedPair();
            if (selectedPair != null) {
                model.removeElement(selectedPair);
                view.setListModel(model.getListModel());
            }
        }
    }
}
