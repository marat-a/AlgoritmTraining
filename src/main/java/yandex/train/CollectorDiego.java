//Тренировки 3.0
//Задача 3. Коллекционер Диего
//https://contest.yandex.ru/contest/45468/problems/3/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class CollectorDiego {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        int quantity = Integer.parseInt(r.readLine());
        String[] numbersOfStickers = r.readLine().split(" ");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(-1);
        for (int i = 0; i < numbersOfStickers.length; i++) {
            treeSet.add(Integer.parseInt(numbersOfStickers[i]));
        }
        ArrayList<Integer> numbersOfDiegoStickers = new ArrayList<>(quantity);
        numbersOfDiegoStickers.addAll(treeSet);
        final int quantityCollectors = Integer.parseInt(r.readLine());
        final String[] minNumberNeeded = r.readLine().split(" ");
        int minNumber;
        for (int i = 0; i < quantityCollectors; i++) {
            minNumber = Integer.parseInt(minNumberNeeded[i]);
            int index = calcInterestingCards(minNumber, numbersOfDiegoStickers);
            System.out.println(index);
        }
    }

    static int calcInterestingCards(int minNumber, ArrayList<Integer> diegoStickers) {
        int left = 0;
        int right = diegoStickers.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (diegoStickers.get(mid) < minNumber) {
                left = mid;
            } else right = mid - 1;

        }
        return left;
    }
}