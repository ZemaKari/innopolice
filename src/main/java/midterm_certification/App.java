package midterm_certification;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем покупателя
        System.out.println("Введите имя покупателя:");
        String name = scanner.nextLine();
        System.out.println("Введите сумму денег покупателя:");
        double money = Double.parseDouble(scanner.nextLine());
        Person person = new Person(name, money);

        // Создаем список продуктов
        List<Product> products = new ArrayList<>();
        System.out.println("\nВведите продукты (для завершения введите 'END'):");

        while (true) {
            System.out.println("Введите название продукта (или 'END'):");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("END")) {
                break;
            }

            System.out.println("Введите цену продукта:");
            double price = Double.parseDouble(scanner.nextLine());
            products.add(new Product(productName, price));
        }

        // Процесс покупки
        System.out.println("\nДоступные продукты:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        System.out.println("\nНачинаем покупки (пока есть деньги):");
        for (Product product : products) {
            if (person.getMoney() <= 0) {
                System.out.println("У " + person.getName() + " закончились деньги!");
                break;
            }
            person.addToBag(product);
        }

        // Выводим результат
        System.out.println("\nИтог покупок:");
        System.out.println(person);

        scanner.close();
    }
}
