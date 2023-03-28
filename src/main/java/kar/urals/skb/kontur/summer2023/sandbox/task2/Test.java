package kar.urals.skb.kontur.summer2023.sandbox.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(sc.nextLine());
        }
        sc.close();

        Arrays.sort(array);

        int midIndex = n / 2;
        int answer = 0;

        for (int i = 0; i < midIndex; i++) {
            if (Math.abs(array[i]) != array[array.length - 1 - i]) {
                if (Math.abs(array[i]) < array[array.length - 1 - i]) {
                    answer = - array[array.length - 1 - i];
                } else {
                    answer = Math.abs(array[i]);
                }
                break;
            }
        }

        if (answer == 0) {
            answer = array[midIndex] > 0 ? - array[midIndex] : Math.abs(array[midIndex]);
        }

        System.out.println(answer);
    }
}
