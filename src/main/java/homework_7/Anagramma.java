package homework_7;

public class Anagramma {
    /**
     * метод который проверяет, является ли слова анограммами друг друга
     * @param s
     * @param t
     * @return
     */
    public static boolean check(String s, String t) {
        s = s.replaceAll("\\s+", "").toLowerCase();
        t = t.replaceAll("\\s+", "").toLowerCase();
        if (s.length() != t.length()) return false;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        java.util.Arrays.sort(arrS);
        java.util.Arrays.sort(arrT);
        return java.util.Arrays.equals(arrS, arrT);
    }
}
