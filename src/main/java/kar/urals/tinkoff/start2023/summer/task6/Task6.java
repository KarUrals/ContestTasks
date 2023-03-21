package kar.urals.tinkoff.start2023.summer.task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] numbers = str.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int s = Integer.parseInt(numbers[1]);

        List<LinkedList<Integer>> listOfStudentsPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = sc.nextLine();

            String[] splitS = str.split(" ");
            int l = Integer.parseInt(splitS[0]);
            int r = Integer.parseInt(splitS[1]);

            LinkedList<Integer> studentPoints = new LinkedList<>();
            for (int j = l; j <= r; j++) {
                studentPoints.add(j);
            }
            listOfStudentsPoints.add(studentPoints);
        }

        sc.close();

        Comparator<LinkedList<Integer>> linkedListComparator = new linkedListComparatorByFirstElement();
        listOfStudentsPoints.sort(linkedListComparator);

        if (checkLinkedListSum(listOfStudentsPoints) < s) {
            do {
                for (int i = 0; i < listOfStudentsPoints.size() - 1; i++) {
                    if (listOfStudentsPoints.get(i).size() == 1) {
                        continue;
                    } else if (listOfStudentsPoints.get(i).peekLast() < listOfStudentsPoints.get(i + 1).peekFirst()) {
                        continue;
                    } else {
                        listOfStudentsPoints.get(i).pollFirst();
                        break;
                    }
                }
                listOfStudentsPoints.sort(linkedListComparator);
            } while (checkLinkedListSum(listOfStudentsPoints) < s);
        }

        System.out.println(findFirstElementOfMiddleList(listOfStudentsPoints));
    }

    public static class linkedListComparatorByFirstElement implements Comparator<LinkedList<Integer>> {
        @Override
        public int compare(LinkedList<Integer> list1, LinkedList<Integer> list2) {
            return list1.peekFirst() - list2.peekFirst();
        }

    }

    public static int checkLinkedListSum(List<LinkedList<Integer>> lists) {
        int sum = 0;

        for (LinkedList<Integer> points : lists) {
            sum = sum + points.peekFirst();
        }

        return sum;
    }

    public static int findFirstElementOfMiddleList(List<LinkedList<Integer>> lists) {
        int middleIndex = lists.size() / 2;
        return lists.get(middleIndex).peekFirst();
    }
}
