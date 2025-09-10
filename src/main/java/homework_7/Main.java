package homework_7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //проверка метода getUniqueElements
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("a");
        arr.add("c");
        Set<String> unique = UniqueElements.getUniqueElements(arr);
        System.out.println(unique);

        // проверка метода check
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(Anagramma.check(s, t));

        //проверка методов класса PowerfulSet
        Set<Integer> set1 = new HashSet<>();
        set1.add(1); set1.add(2); set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0); set2.add(1); set2.add(2); set2.add(4);
        // проверка метода пересечения
        System.out.println(PowerfulSet.intersection(set1, set2));
        // проверка метода объединения
        System.out.println(PowerfulSet.union(set1, set2));
        // проверка метода уникальных элементов
        System.out.println(PowerfulSet.relativeComplement(set1, set2));
    }


}
