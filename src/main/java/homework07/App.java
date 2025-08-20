package homework07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            // Создаем покупателя
            Person person = createPerson(scanner);

            // Создаем список продуктов
            List<Product> products = createProducts(scanner, dateFormatter);

            // Процесс покупки
            processPurchases(scanner, person, products);

            // Выводим результат
            System.out.println("\n=== ИТОГ ПОКУПОК ===");
            System.out.println(person);

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Person createPerson(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите имя покупателя:");
                String name = scanner.nextLine().trim();
                System.out.println("Введите сумму денег покупателя:");
                double money = Double.parseDouble(scanner.nextLine().trim());
                return new Person(name, money);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage() + " Попробуйте снова.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Введите корректную сумму денег!");
            }
        }
    }

    private static List<Product> createProducts(Scanner scanner, DateTimeFormatter dateFormatter) {
        List<Product> products = new ArrayList<>();

        System.out.println("\n=== СОЗДАНИЕ ПРОДУКТОВ ===");
        System.out.println("Введите продукты (для завершения введите 'END'):");
        System.out.println("Формат: [тип] название цена [скидка_% дата_окончания]");
        System.out.println("Типы: 1 - обычный, 2 - со скидкой");
        System.out.println("Примеры:");
        System.out.println("1 Хлеб 50.0");
        System.out.println("2 Молоко 80.0 20 25.12.2024  (20% скидка до 25.12.2024)");
        System.out.println("2 Шоколад 120.0 50 15.12.2024  (50% скидка до 15.12.2024)");

        while (true) {
            System.out.println("\nВведите данные продукта (или 'END'):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("END")) {
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            try {
                String[] parts = input.split(" ");
                if (parts.length < 3) {
                    System.out.println("Неверный формат! Минимум 3 параметра: тип название цена");
                    continue;
                }

                int type = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product;
                if (type == 1) {
                    product = new Product(name, price);
                    products.add(product);
                    System.out.println("Обычный продукт добавлен: " + product);
                } else if (type == 2) {
                    if (parts.length < 5) {
                        System.out.println("Для скидочного продукта нужны: тип название цена скидка_% дата");
                        continue;
                    }
                    int discountPercent = Integer.parseInt(parts[3]);
                    LocalDate endDate = LocalDate.parse(parts[4], dateFormatter);
                    product = new DiscountProduct(name, price, discountPercent, endDate);
                    products.add(product);
                    System.out.println("Скидочный продукт добавлен: " + product);
                } else {
                    System.out.println("Неверный тип продукта! Используйте 1 или 2");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка формата чисел! Проверьте ввод.");
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка формата даты! Используйте dd.MM.yyyy (например: 25.12.2024)");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        return products;
    }

    private static void processPurchases(Scanner scanner, Person person, List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Нет доступных продуктов для покупки!");
            return;
        }

        System.out.println("\n=== ДОСТУПНЫЕ ПРОДУКТЫ ===");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String productInfo;

            if (product instanceof DiscountProduct) {
                DiscountProduct discountProduct = (DiscountProduct) product;
                if (discountProduct.isDiscountActive()) {
                    productInfo = String.format("%s - %.2f руб. (-%d%%)",
                            product.getName(), product.getPrice(), discountProduct.getDiscountPercent());
                } else {
                    productInfo = String.format("%s - %.2f руб. (скидка недействительна)",
                            product.getName(), product.getPrice());
                }
            } else {
                productInfo = String.format("%s - %.2f руб.", product.getName(), product.getPrice());
            }

            System.out.println((i + 1) + ". " + productInfo);
        }

        System.out.println("\n=== ПРОЦЕСС ПОКУПОК ===");
        System.out.println("Введите номер продукта для покупки или 'END' для завершения:");

        while (true) {
            System.out.printf("\nТекущий баланс: %.2f руб.\n", person.getMoney());
            System.out.println("Введите номер продукта (или 'END'):");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            try {
                int productIndex = Integer.parseInt(input) - 1;
                if (productIndex < 0 || productIndex >= products.size()) {
                    System.out.println("Неверный номер продукта! Доступные номера: 1-" + products.size());
                    continue;
                }

                Product selectedProduct = products.get(productIndex);

                // Показываем информацию о скидке перед покупкой
                if (selectedProduct instanceof DiscountProduct) {
                    DiscountProduct discountProduct = (DiscountProduct) selectedProduct;
                    if (discountProduct.isDiscountActive()) {
                        System.out.printf(" Скидка %d%% действует! Цена со скидкой: %.2f руб. (было: %.2f руб.)\n",
                                discountProduct.getDiscountPercent(),
                                discountProduct.getPrice(),
                                discountProduct.getOriginalPrice());
                    } else {
                        System.out.printf("⚠️  Скидка закончилась %s. Текущая цена: %.2f руб.\n",
                                discountProduct.getDiscountEndDate(),
                                discountProduct.getPrice());
                    }
                }

                // Пытаемся купить продукт
                if (person.canAfford(selectedProduct)) {
                    person.addToBag(selectedProduct);
                } else {
                    System.out.printf(" %s не может позволить себе %s (нужно: %.2f руб., доступно: %.2f руб.)\n",
                            person.getName(), selectedProduct.getName(), selectedProduct.getPrice(), person.getMoney());
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректный номер продукта!");
            }
        }
    }
}