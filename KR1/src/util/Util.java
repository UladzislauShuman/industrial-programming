package util;

import cars.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util
{
    public static List<Car> sortByPriceAndRating(List<Car> cars)
    {
        return cars.stream().sorted(
                Comparator.comparingInt(Car::getPrice).reversed()
                        .thenComparingInt(Car::getRating).reversed()
        ).collect(Collectors.toList());
    }

    public static long coutCarsByColor(List<Car> cars, int color)
    {
        return cars.stream().filter(car -> car.getColor() == color).count();
    }

    public static int binarySearch(List<Car> cars, Car searchCar)
    {
        return Collections.binarySearch(
                cars.stream().sorted(new CarComparator()).toList(),
                searchCar,
                new CarComparator());
    }

    public static List<Car> sortByPriceColorRatio(List<Car> cars)
    {
        return cars.stream().sorted(
                Comparator.comparingDouble(
                        car -> (double) car.getPrice() / car.getColor()
                )
        ).toList();
    }

    public static List<String> getCarsByStartingWithT(List<Car> cars)
    {
        return cars.stream()
                .map(Car::getName)
                .filter(name -> name.startsWith("T"))
                .distinct()
                .collect(Collectors.toList());
    }


    //работа с файлами
    public static List<Car> readCars(String filename)
    {
        List<Car> cars = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String currentLine;
            while ((currentLine = br.readLine()) != null)
            {
                String[] parts = currentLine.split(" ");

                String className = parts[0];
                String name = parts[1];
                int color = Integer.parseInt(parts[2]);
                int rating = Integer.parseInt(parts[3]);
                switch (className) {
                    case "PassengerCar":
                        int maxSpeed = Integer.parseInt(parts[4]);
                        cars.add(new PassengerCar(name, color, rating, maxSpeed));
                        break;
                    case "Bus" :
                        int seatCount = Integer.parseInt(parts[4]);
                        int doorCount = Integer.parseInt(parts[5]);
                        cars.add(new Bus(name, color, rating, seatCount, doorCount));
                        break;
                    default :
                        System.out.println("Unknown class: " + className);
                        break;
                }
            }
        }
        catch (IOException e)
        {
            return cars;
        }
        return cars;
    }
}

