package homework_7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElements {
    /**
     * метод который убирает дубликаты из коллекции
     * @param list
     * @return
     * @param <T>
     */
    public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // HashSet автоматически убирает дубликаты
        return new HashSet<>(list);
    }
}
