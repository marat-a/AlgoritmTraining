//Тренировки 3.0
//Задача 2. Красивая строка
//https://contest.yandex.ru/contest/45468/problems/2/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BeautifulString {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));
        final int k = Integer.parseInt(r.readLine());
        final char[] string = r.readLine().toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        int maxValue = 0;
        for (char c : string) {
            charMap.putIfAbsent(c, 0);
        }
        int leftReplaces;
        int leftPosition;
        int rightPosition;
        for (char ch : charMap.keySet()) {
            rightPosition = 0;
            leftPosition = 0;
            leftReplaces = k;
            while (rightPosition < string.length) {
                if (ch == string[rightPosition]) {
                    rightPosition++;
                } else if (leftReplaces > 0) {
                    rightPosition++;
                    leftReplaces--;
                } else {
                    if (rightPosition - leftPosition > maxValue) maxValue = rightPosition - leftPosition;
                    if (string[leftPosition] != ch) {
                        leftReplaces++;
                    }
                    leftPosition++;
                }
            }
            if (rightPosition - leftPosition > maxValue) maxValue = rightPosition - leftPosition;
        }
        System.out.println(maxValue);
    }
}
