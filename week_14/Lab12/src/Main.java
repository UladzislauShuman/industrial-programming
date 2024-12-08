import mvc.model.MapModel;
import mvc.view.MapView;
import mvc.controller.MapController;
import mydatastructure.iterators.ShumanMapIterator;
import mydatastructure.map.ShumanMap;
import mydatastructure.map.ShumanPair;

//public class Main {
//    public static void main(String[] args)
//    {
//        ShumanMap<String, String> map = new ShumanMap<>();
//
//        map.put("key1", "value1");
//        map.put("key2", "value2");
//        map.put("key3", "value3");
//
//        ShumanMapIterator<String, String> iterator = map.iterator();
//
//        System.out.println("Элементы карты:");
//        while (iterator.isDone())
//        {
//            ShumanPair<String, String> pair = iterator.getCurrentItem();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            try {
//                iterator.next();
//            }
//            catch (Exception e)
//            {
//                System.out.println(e.getMessage());
//            }
//        }
//        System.out.println("Значение для 'key2': " + map.get("key2"));
//        System.out.println("Строковое представление карты: " + map.toString());
//        System.out.println("Размер карты: " + map.size());
//        System.out.println("Карта пуста? " + map.isEmpty());
//        map.clear(); System.out.println("Карта после очистки пуста? " + map.isEmpty());
//
//        MapModel<String, String> model = new MapModel<>();
//        MapView<String, String> view = new MapView<>();
//        new MapController<>(model, view);
//        //view.setVisible(true);
//    }
//}

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShumanMap<String,String> map = new ShumanMap<>();
                map.put("key", "value");
                System.out.println(map.toString());
                map.remove("key", "value");
                System.out.println(map.toString());

                MapModel<String, String> model = new MapModel<>();
                MapView<String, String> view = new MapView<>();
                MapController<String, String> controller = new MapController<>(model, view);
                //view.setVisible(true);


            }
        });
    }
}
