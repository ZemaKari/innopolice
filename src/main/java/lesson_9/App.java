package lesson_9;
import  java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Televisor televisor1 = new Televisor("Color",
                "LED",
                15,
                16.800,
                "LG-K",
                "LG",
                50);

        Televisor televisor2 = new Televisor("Color",
                "OLED",
                32,
                55.200,
                "Sam-2",
                "Samsung",
                60);
        System.out.println("Нажмите 0 если выключить, любое число - включить: ");
        int num = scanner.nextInt();
        System.out.println(televisor2.turnOnOff(num));
        televisor2.discount(30);
        televisor2.info();


    }
}
