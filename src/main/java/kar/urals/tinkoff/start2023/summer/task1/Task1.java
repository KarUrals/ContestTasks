package kar.urals.tinkoff.start2023.summer.task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        String[] numbers = str.split(" ");

        String[] sortedNumbersAsc = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbersAsc);

        String[] sortedNumbersDesc = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbersDesc, Collections.reverseOrder());

        if(Arrays.equals(numbers, sortedNumbersAsc) || Arrays.equals(numbers, sortedNumbersDesc)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
