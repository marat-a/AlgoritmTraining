import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MinTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }
        List<Integer> buys = new ArrayList<>();
        List<Integer> sells = new ArrayList<>();
        Map<Integer, Integer> kv= new HashMap<>();
        int[] prefix = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            prefix[i] = prices[i + 1] - prices[i];
        }


    }

}

