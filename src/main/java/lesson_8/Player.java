package lesson_8;
import java.util.Random;

public class Player {
    private final String name;
    private int choice;

    public Player(String name) {
        this.name = name;
    }

    public void makeRandomChoice() {
        this.choice = new Random().nextInt(3); // 0-камень, 1-ножницы, 2-бумага
    }

    public String getChoiceName() {
        return switch (this.choice) {
            case 0 -> "камень";
            case 1 -> "ножницы";
            case 2 -> "бумага";
            default -> "неизвестно";
        };
    }

    public int getChoice() {
        return choice;
    }

    public String getName() {
        return name;
    }


}
