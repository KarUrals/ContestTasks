package kar.urals.tinkoff.start2023.summer.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        List<Integer> numbers = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .toList();

        sc.close();

        List<Integer> correctIndices = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // how many times each number appears in the list
        map.put(numbers.get(0), 1);

        for (int i = 2; i <= n; i++) {
            int numberOnPosition = numbers.get(i - 1);
            int count = map.containsKey(numberOnPosition) ? map.get(numberOnPosition) + 1 : 1;

            map.put(numberOnPosition , count);

            List<Integer> uniqueNumbers = new ArrayList<>(map.values());
            uniqueNumbers.sort(Comparator.naturalOrder());

            if (checkListOfUniqueNumbers(uniqueNumbers)) {
                correctIndices.add(i);
            }
        }

        System.out.println(correctIndices.get(correctIndices.size() - 1));
    }

    public static boolean checkListOfUniqueNumbers(List<Integer> list) {
        if (list.size() == 1) {
            return true;
        } else if (list.size() == 2) {
            return checkListOfTwo(list);
        } else {
            if (list.get(0) == 1 && checkListFromSecondToEnd(list)) {
                return true;
            }
            if (checkListFromFirstToPenalt(list) && (list.get(list.size() - 1) - list.get(list.size() - 2)) == 1) {
                return true;
            }
            return false;
        }
    }

    public static boolean checkListFromSecondToEnd(List<Integer> list) {
        for (int i = 1; i < (list.size() - 1); i++) {
            if (list.get(i) != list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkListFromFirstToPenalt(List<Integer> list) {
        for (int i = 0; i < (list.size() - 2); i++) {
            if (list.get(i) != list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkListOfTwo(List<Integer> list) {
        if (Math.abs(list.get(0) - list.get(1)) == 1) {
            return true;
        }
        if (list.get(0) == 1 && list.get(1) == 1) {
            return true;
        }
        return false;
    }
}