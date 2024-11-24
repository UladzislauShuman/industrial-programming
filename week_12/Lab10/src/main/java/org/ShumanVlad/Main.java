package org.ShumanVlad;

import org.ShumanVlad.iterators.ShumanMapIterator;
import org.ShumanVlad.map.ShumanMap;
import org.ShumanVlad.map.ShumanPair;

public class Main {
    public static void main(String[] args)
    {
        ShumanMap<String, String> map = new ShumanMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        ShumanMapIterator<String, String> iterator = map.iterator();

        System.out.println("Элементы карты:");
        while (iterator.isDone())
        {
            ShumanPair<String, String> pair = iterator.getCurrentItem();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            try {
                iterator.next();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Значение для 'key2': " + map.get("key2"));
        System.out.println("Строковое представление карты: " + map.toString());
        System.out.println("Размер карты: " + map.size());
        System.out.println("Карта пуста? " + map.isEmpty());
        map.clear(); System.out.println("Карта после очистки пуста? " + map.isEmpty());
    }
}