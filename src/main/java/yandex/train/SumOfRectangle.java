import java.util.Scanner;

public class SumOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] a = new int[n][m];
        int[][] prefix = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                prefix[i+1][j+1] = a[i][j] + prefix[i][j+1] + prefix[i+1][j] - prefix[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int sum = prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
            System.out.println(sum);
        }
    }
}