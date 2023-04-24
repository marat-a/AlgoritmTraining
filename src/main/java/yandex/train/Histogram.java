//Тренировки 3.0
//Задача 1. Гистограмма
//https://contest.yandex.ru/contest/45468/problems/1/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class Histogram {
    public static void main(String[] args) throws Exception {

        TreeMap<Character, Integer> charMap = new TreeMap<>();

        BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));
        String line;
        while ((line = r.readLine()) != null) {
            char[] charAtLine = line.toCharArray();
            for (char c : charAtLine) {
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else if (c != ' ' && c != '\n') charMap.put(c, 1);
            }
        }
        int maxValue = charMap.values().stream().max(Integer::compareTo).get();
        for (int i = maxValue; i > 0; i--) {
            for (int value : charMap.values()
            ) {
                if (value >= i) System.out.print("#");
                else System.out.print(" ");

            }
            System.out.println();
        }
        for (char c : charMap.keySet()
        ) {
            System.out.print(c);
        }
    }
}