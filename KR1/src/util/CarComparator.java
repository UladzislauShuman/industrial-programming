package util;

import cars.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        int priceCompare = Integer.compare(car1.getPrice(), car2.getPrice());
        if (priceCompare != 0)
        {
            return priceCompare;
        }
        int ratingCompare = Integer.compare(car1.getRating(), car2.getRating());
        if (ratingCompare != 0)
        {
            return ratingCompare;
        }
        int nameCompare = car1.getName().compareTo(car2.getName());
        if (nameCompare != 0)
        {
            return nameCompare;
        }
        return Integer.compare(car1.getColor(), car2.getColor());
    }
}
