package kar.urals.tinkoff.start2023.summer.task2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        String[] numbers = str.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        int k = Integer.parseInt(numbers[2]);

        float perfomance = (float) m / (float) k;
        float time = (float) n / perfomance;
        int answer = (int) Math.ceil(time);

        System.out.println(answer);
    }
}
