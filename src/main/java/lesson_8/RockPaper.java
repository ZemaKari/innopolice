package lesson_8;

public class RockPaper {
    public static String Winner(Player player1, Player player2) {
        if (player1.getChoice() == player2.getChoice()) {
            return "Ничья!";
        }

        if ((player1.getChoice() == 0 && player2.getChoice() == 1) || // камень > ножницы
                (player1.getChoice() == 1 && player2.getChoice() == 2) || // ножницы > бумага
                (player1.getChoice() == 2 && player2.getChoice() == 0)) {  // бумага > камень
            return player1.getName() + " выиграл!";
        }

        return player2.getName() + " выиграл!";
    }
}