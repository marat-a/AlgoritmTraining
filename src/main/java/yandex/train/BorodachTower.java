import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BorodachTower {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));

        String[] NAndM = r.readLine().split(" ");
        int platforms = Integer.parseInt(NAndM[0]);
        int volunteers = Integer.parseInt(NAndM[1]);
        long[] platformWidth = new long[platforms];
        long[] volunteersWidth = new long[volunteers];
        String[] width = r.readLine().split(" ");
        for (int i = 0; i < platforms; i++) {
            platformWidth[i] = Long.parseLong(width[i]);
        }
        width = r.readLine().split(" ");
        for (int i = 0; i < volunteers; i++) {
            volunteersWidth[i] = Long.parseLong(width[i]);
        }


        long minWidth = 0;
        List<Long> platformUnderSunWidths = new ArrayList<>();
        for (int i = platforms - 1; i >= 0; i--) {
            if (platformWidth[i] > minWidth) {
                platformUnderSunWidths.add(platformWidth[i] - minWidth);
                minWidth = platformWidth[i];
            }

        }
        platformUnderSunWidths.sort(null);
        Arrays.sort(volunteersWidth);
        int result = 0;
        int volIndex = 0;
        while (volIndex < volunteers) {
            for (Long platformUnderSunWidth : platformUnderSunWidths) {
                if (volunteersWidth[volIndex] <= platformUnderSunWidth) {
                    result++;
                }
                volIndex++;
            }
        }
        System.out.println(result);
    }

}
