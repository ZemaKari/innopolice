package lesson_8;

public class Main {
    public static void main(String[] args) {
        Player vasya = new Player("Вася");
        Player petya = new Player("Петя");

        vasya.makeRandomChoice();
        petya.makeRandomChoice();

        System.out.println(vasya.getName() + " показал: " + vasya.getChoiceName());
        System.out.println(petya.getName() + " показал: " + petya.getChoiceName());

        System.out.println(RockPaper.Winner(vasya, petya));
    }
}
