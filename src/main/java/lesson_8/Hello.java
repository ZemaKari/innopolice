package lesson_8;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        System.out.print("Привет, " + userName);
        scanner.close();
    }
}
