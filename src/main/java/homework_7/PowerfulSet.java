package homework_7;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    /**
     * Пересечение двух наборов
     */

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2); // оставляет только элементы, которые есть и в set2
        return result;
    }

    /**
     * Объединение всех элементов
     * @param set1
     * @param set2
     * @return
     * @param <T>
     */

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2); // добавляет все элементы из set2 (уникальные)
        return result;
    }

    /**
     * Разность множеств
     * @param
     * @return
     */

    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2); // удаляет все элементы, которые есть во втором множестве
        return result;
    }
}
