package kar.urals.skb.kontur.summer2023.sandbox.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] numbers = str.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        sc.close();

        int maxArea = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == '.') {
                    int width = 1;
                    while (j + width < m && grid[i][j + width] == '.') {
                        width++;
                    }
                    int height = 1;
                    while (i + height < n && grid[i + height][j] == '.') {
                        height++;
                    }
                    int area = width * height;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}
