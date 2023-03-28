package kar.urals.skb.kontur.summer2023.sandbox.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        String[] digits = str.split("");

        Arrays.sort(digits);
        int minNumber = Integer.parseInt(String.join("", digits));

        Arrays.sort(digits, Comparator.reverseOrder());
        int maxNumber = Integer.parseInt(String.join("", digits));

        System.out.println(maxNumber - minNumber);
    }
}
