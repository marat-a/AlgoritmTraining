//Тренировки 3.0
//Задача 14. Сортировка вагонов lite
//https://contest.yandex.ru/contest/45468/problems/14/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class VansSortLite {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        int quantity = Integer.parseInt(r.readLine());
        String[] vansLine = r.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < quantity; i++) {
            stack.push(Integer.parseInt(vansLine[i]));
            while (!stack.isEmpty() && stack.peek() == index + 1) {
                stack.pop();
                index++;

            }
        }
        if (stack.empty()) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
