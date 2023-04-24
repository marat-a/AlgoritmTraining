import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class YandexBar {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));
        String[] NAndM = r.readLine().split(" ");
        int n = Integer.parseInt(NAndM[0]);
        ArrayList<String> glass = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String layer = r.readLine();
            glass.add(i, layer);
        }
        int ingridientsNumber = Integer.parseInt(r.readLine());
        int nextLayer = 2;
        for (int k = 0; k < ingridientsNumber; k++) {
            String[] description = r.readLine().split(" ");
            int quantity = Integer.parseInt(description[1]);
            String symbol = description[2];
            for (int x = 0; x < quantity; x++) {
                glass.set(n - nextLayer, glass.get(n - nextLayer).replaceAll(" ", Matcher.quoteReplacement(symbol)));
                nextLayer++;
            }
        }
        for (String layer : glass
        ) {
            System.out.println(layer);
        }
    }
}
