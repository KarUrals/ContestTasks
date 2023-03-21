package kar.urals.tinkoff.start2023.summer.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        List<Integer> daysBalance = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toList();

        sc.close();

        List<String> allSectionsList = new ArrayList<>();
        List<String> goodPeriodsList = new ArrayList<>();

        String delimiter = " ";
        int numberOfSegments = 1;

        for (int i = n; i > 1; i--) {
            int index = 0;

            for (int j = 1; j <= numberOfSegments; j++) {
                List<Integer> section = new ArrayList<>();

                for (int k = index; k < (i + index); k++) {
                    section.add(daysBalance.get(k));
                }

                String result = section.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(delimiter));
                allSectionsList.add(result);

                if (checkListSum(section) == 0) {
                    goodPeriodsList.add(result);
                }
                index++;
            }
            numberOfSegments++;
        }

        int answer = 0;
        for (String section : allSectionsList) {
            for (String goodPeriod : goodPeriodsList) {
                if (section.contains(goodPeriod)) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static int checkListSum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum = sum + i;
        }
        return sum;
    }
}
