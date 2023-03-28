package kar.urals.skb.kontur.summer2023.contest.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] sortedA = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedA);
        int maxContrast = sortedA[sortedA.length - 1];
        int minContrast = sortedA[0];

        int minDay = 0;
        int maxDay = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == minContrast) {
                minDay = i + 1;
                break;
            }
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == maxContrast) {
                maxDay = i + 1;
                break;
            }
        }
        System.out.println(maxDay + " " + minDay);
    }
}