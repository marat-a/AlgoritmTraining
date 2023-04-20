//Тренировки 3.0
//Задача 5. Хорошая строка
//https://contest.yandex.ru/contest/45468/problems/5/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GoodString {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        final int allLettersQuantity = Integer.parseInt(r.readLine());
        List<Integer> charMap = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < allLettersQuantity; i++) {
            charMap.add(Integer.parseInt(r.readLine()));
        }
        for (int i = 0; i < charMap.size()-1; i++) {
            if (charMap.get(i) > charMap.get(i + 1)) {
                total += charMap.get(i + 1);
            } else total += charMap.get(i);
        }
        System.out.println(total);
    }
}
