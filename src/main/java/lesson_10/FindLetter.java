package lesson_10;

import java.util.Scanner;

public class FindLetter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";  // Строка клавиатуры

        while (true) {  // В бесконечном цикле запрашиваем букву
            System.out.println("Введите букву английского алфавита: ");
            String input = scanner.nextLine().trim().toLowerCase();//удаляем пробелы, переводим в нижний регистр
            // Проверка на пустой ввод
            if (input.isEmpty()) {
                System.out.println("Вы ничего не ввели!");
                continue;//возвращаемся в начало цикла
            }
            // Проверка, что введен только один символ
            if (input.length() != 1) {
                System.out.println("Введите только одну букву английского алфавита!");
                continue;//возвращаемся в начало цикла
            }
            char letter = input.charAt(0);//для инициализации переменной letter,
            // инициализируется буквой которую ввел пользователь, тк буква  одна и без пробелов,
            // поэтому по индексу 0
            int index = alphabet.indexOf(letter);//находим индекс искомой буквы

            if (index == -1) {//проверяем есть ли такая буква
                System.out.println("Такой буквы нет в английском алфавите");
            } else {
                int leftIndex = (index - 1 + alphabet.length()) % alphabet.length();//находим индекс буквы слева
                char leftChar = alphabet.charAt(leftIndex);//по индексу находим букву
                System.out.println("Буква слева на клавиатуре: " + leftChar);
            }
            // Предложение выйти или продолжить
            System.out.println("Хотите продолжить? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                break;//если не хотим продолжать , то выходим их цикла
            }
        }
        scanner.close();  // Закрываем сканер
        System.out.println("Программа завершена.");
    }
}