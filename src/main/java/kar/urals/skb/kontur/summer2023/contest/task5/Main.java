package kar.urals.skb.kontur.summer2023.contest.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] numbers = s.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        int firstMax = -1;
        int nIndex = -1;
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nString = scanner.nextLine();
            String[] nNumbers = nString.split("");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(nNumbers[j]);
                if (number > firstMax) {
                    firstMax = number;
//                    nIndex = i + 1;
                }
                list.add(number);
            }
            lists.add(list);
        }
        int indexMax = 0;

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int countMax = 0;
            for (int num : list) {
                if (num == firstMax) {
                    countMax++;
                }
            }
            if (countMax > indexMax) {
                nIndex = i + 1;
                indexMax = countMax;
            }
        }

//        System.out.println(lists);
//        System.out.println(firstMax);
//        System.out.println(nIndex);
        lists.remove(nIndex - 1);
//        System.out.println(lists);

        int secondMax = -1;
        int mIndex = -1;

        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                if (number > secondMax) {
                    secondMax = number;
                    mIndex = i + 1;
                }
            }
        }
//        System.out.println(mIndex);

        System.out.println(nIndex + " " + mIndex);
    }
}
