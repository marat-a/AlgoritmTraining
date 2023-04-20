//Тренировки 3.0
// Задача 4. Контрольная работа
//https://contest.yandex.ru/contest/45468/problems/4/

import java.io.BufferedReader;
import java.io.FileReader;

public class ControlWork {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        int pupils = Integer.parseInt(r.readLine());
        int variants = Integer.parseInt(r.readLine());
        int petyaRow = Integer.parseInt(r.readLine());
        int position = Integer.parseInt(r.readLine());

        int petyaAbsPosition = (petyaRow - 1) * 2 + position;
        int rowBefore = -2;
        int rowAfter = -3;

        if ((petyaAbsPosition - variants) >= 1) {
            rowBefore = ((petyaAbsPosition - variants) % 2 > 0) ? (petyaAbsPosition - variants) / 2 + 1 : (petyaAbsPosition - variants) / 2;
        }
        if ((petyaAbsPosition + variants) <= pupils) {
            rowAfter = ((petyaAbsPosition + variants) % 2 > 0) ? (petyaAbsPosition + variants) / 2 + 1 : (petyaAbsPosition + variants) / 2;
        }
        if (rowAfter > 0 && rowBefore > 0) {
            if (petyaRow - rowBefore < rowAfter - petyaRow) {
                System.out.println(rowBefore);
                System.out.println(((petyaAbsPosition - variants) % 2 > 0) ? 1 : 2);
            } else {
                System.out.println(rowAfter);
                System.out.println(((petyaAbsPosition + variants) % 2 > 0) ? 1 : 2);
            }
        } else if (rowBefore > 0) {
            System.out.println(rowBefore);
            System.out.println(((petyaAbsPosition - variants) % 2 > 0) ? 1 : 2);
        } else if (rowAfter > 0) {
            System.out.println(rowAfter);
            System.out.println(((petyaAbsPosition + variants) % 2 > 0) ? 1 : 2);
        } else System.out.println(-1);
    }
}