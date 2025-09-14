package homework011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("a123me", "Mercedes", "White", 0, 8300000);
        Car car2 = new Car("b873of", "Volga", "Black", 0, 673000);
        Car car3 = new Car("w487mn", "Lexus", "Grey", 76000, 900000);
        Car car4 = new Car("p987hj", "Volga", "Red", 610, 704340);
        Car car5 = new Car("c987ss", "Toyota", "White", 254000, 761000);
        Car car6 = new Car("o983op", "Toyota", "Black", 698000, 740000);
        Car car7 = new Car("p146op", "BMW", "White", 271000, 850000);
        Car car8 = new Car("u893ii", "Toyota", "Purple", 210900, 440000);
        Car car9 = new Car("l097df", "Toyota", "Black", 108000, 780000);
        Car car10 = new Car("y876wd", "Toyota", "Black", 160000, 1000000);

        // Список автомобилей
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);

        // Выводим автомобили
        for (Car car : cars) {
            System.out.println(car);
        }

        String colorToFind = "White";
        int mileageToFind = 108000;

        /**
         * метод который выводит номера всех автомобилей с заданным цветом или ценой
         */
        List<String> numbers = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        System.out.println("Номера автомобилей с заданным цветом и пробегом: " + numbers);

        /**
         * метод который выводит цвет автомобиля с минимальной стоимостью:
         */
        cars.stream()
                .min(Comparator.comparingDouble(Car::getPrice))
                .map(Car::getColor)
                .ifPresent(System.out::println);

        /**
         * метод modelToFind который находит среднюю стоимость автомобилей по заданной  модели
         */
        String modelToFind = "Toyota";
        OptionalDouble avg = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind))
                .mapToDouble(Car::getPrice)
                .average();

        if (avg.isPresent()) {
            System.out.println("Средняя цена автомобиля: " + avg.getAsDouble());
        } else {
            System.out.println("Нет такой модели");
        }




    }



}
