package kar.urals.skb.kontur.summer2023.sandbox.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(sc.nextLine());
        }
        sc.close();

        Arrays.sort(array);

        int answer = 0;

        while (array.length > 1) {
            if (Math.abs(array[0]) == array[array.length - 1]) {
                array = Arrays.copyOfRange(array, 1, array.length - 1);
            } else {
                if (Math.abs(array[0]) == array[array.length - 2]) {
                    answer = - array[array.length - 1];
                } else {
                    answer = Math.abs(array[0]);
                }
                break;
            }
        }

        if (array.length == 1) {
            if (array[0] > 0) {
                answer = - array[0];
            } else {
                answer = Math.abs(array[0]);
            }
        }

        System.out.println(answer);
    }
}
