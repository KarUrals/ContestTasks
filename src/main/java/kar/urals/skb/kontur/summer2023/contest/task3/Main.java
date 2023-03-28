package kar.urals.skb.kontur.summer2023.contest.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int left = 0, right = 0, count = 0, sum = 0, zeros = 0;
        while (right < n) {
            if (a[right] == 0) {
                zeros++;
            }
            sum += a[right];
            while (zeros > 1 || sum > k) {
                if (a[left] == 0) {
                    zeros--;
                }
                sum -= a[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        System.out.println(count);
    }
}
