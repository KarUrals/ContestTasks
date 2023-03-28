package kar.urals.skb.kontur.summer2023.contest.task4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        Set<Integer> sums = new HashSet<>();
        generateSums(a, 0, 0, sums);
        System.out.println(sums.size());
    }

    private static void generateSums(int[][] a, int i, int sum, Set<Integer> sums) {
        if (i == a.length) {
            sums.add(sum);
            return;
        }
        for (int j = 0; j < 6; j++) {
            generateSums(a, i + 1, sum + a[i][j], sums);
        }
    }
}
