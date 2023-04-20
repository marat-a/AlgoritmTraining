import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SNTP {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        String[] timeAString = r.readLine().split(":");
        String[] timeBString = r.readLine().split(":");
        String[] timeCString = r.readLine().split(":");

        int timeAInSeconds = Integer.parseInt(timeAString[0]) * 3600
                + Integer.parseInt(timeAString[1]) * 60 + Integer.parseInt(timeAString[2]);
        int timeBInSeconds = Integer.parseInt(timeBString[0]) * 3600
                + Integer.parseInt(timeBString[1]) * 60 + Integer.parseInt(timeBString[2]);
        int timeCInSeconds = Integer.parseInt(timeCString[0]) * 3600
                + Integer.parseInt(timeCString[1]) * 60 + Integer.parseInt(timeCString[2]);

        if (timeCInSeconds < timeAInSeconds) {
            timeCInSeconds += 24 * 3600;
        }

        int delay = (timeCInSeconds - timeAInSeconds) / 2;

        int actualTime = timeBInSeconds + delay;
        if ((timeCInSeconds - timeAInSeconds) % 2 != 0) {
        actualTime++;
        }

        if (actualTime / 3600 >= 24) {
            actualTime -= 24 * 3600;
        }
        System.out.printf("%02d:%02d:%02d", actualTime / 3600, actualTime % 3600 / 60, (actualTime % 3600) % 60);
    }
}
