//Стажировка весна-лето 2023 | бэкенд
//Задача B. Горе от перфекционизма
//https://contest.yandex.ru/contest/44525/problems/B/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class Sculpture {
    Integer weight;
    Integer index;

    public Sculpture(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }
}

public class GriefFromPerfectionism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String[] first = reader.readLine().split(" ");
        String[] sculptures = reader.readLine().split(" ");
        int quantity = Integer.parseInt(first[0]);
        int idealWeight = Integer.parseInt(first[1]);
        long minutes = Long.parseLong(first[2]);
        ArrayList<Sculpture> sculpts = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            sculpts.add(new Sculpture(Math.abs(Integer.parseInt(sculptures[i]) - idealWeight), i));
        }
        sculpts.sort(Comparator.comparing(p -> p.weight));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < sculpts.size(); i++) {
            if (minutes >= sculpts.get(i).weight) {
                minutes -= sculpts.get(i).weight;
                result.add(sculpts.get(i).index);
            } else return;
        }
        result.sort(null);
        System.out.println(result.size());
        if (!result.isEmpty()) {
            for (Integer x : result) {
                System.out.print(x + 1 + " ");
            }
        }
    }
}
