package kar.urals.skb.kontur.summer2023.sandbox.task5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        // Create an array to store the house numbers for each street
        Map<String, List<Integer>> houses = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts = s.split("(?<=\\D)(?=\\d)");
            String street = parts[0];
            int houseNumber = Integer.parseInt(parts[1]);

            List<Integer> list = houses.getOrDefault(street, new ArrayList<>());
            list.add(houseNumber);
            houses.put(street, list);
        }

        int m = Integer.parseInt(sc.nextLine());
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tasks.add(sc.nextLine());
        }
        sc.close();

        // Sort the house numbers for each street
        for (List<Integer> list : houses.values()) {
            Collections.sort(list);
        }

        // Find the next available house number for each task
        for (int i = 0; i < m; i++) {
            String street = tasks.get(i);
            List<Integer> list = houses.getOrDefault(street, new ArrayList<>());

            int left = 0, right = list.size(), mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (list.get(mid) > mid + 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int nextHouseNumber = left + 1;
            System.out.println(nextHouseNumber);

            // Add the new house number to the list for the current street
            list.add(left, nextHouseNumber);
            houses.put(street, list);
        }
    }
}