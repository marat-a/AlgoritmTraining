import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BoringLection {
    public static void main(String[] args) throws IOException {
        final BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));
        String s = r.readLine();

        Map<Character, Long> map = new HashMap<>();
        long length = (long) s.length();

        for (int i = 0; i < length; i++) {
            Long sum = (length - i) * (i + 1);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0L) + sum);
        }

        TreeMap<Character, Long> sortedMap = new TreeMap<>(map);

        for (char c : sortedMap.keySet()) {
            System.out.println(c + ": " + map.get(c));
        }
    }
}