package kar.urals.tinkoff.start2023.summer.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int strLength = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        sc.close();

        String[] symbols = str.split("");

        int aFirstIndex = findIndex(symbols, "a");
        int bFirstIndex = findIndex(symbols, "b");
        int cFirstIndex = findIndex(symbols, "c");
        int dFirstIndex = findIndex(symbols, "d");
        String s = "";
        String subStr = "";
        String first = "";

        List<String> strings = new ArrayList<>();

        if (aFirstIndex == -1 || bFirstIndex == -1 || cFirstIndex == -1 || dFirstIndex == -1) {
            System.out.println(-1);
            return;
        } else {
            s = symbols[0];
            for (int i = 1; i < strLength; i++) {

                if (!symbols[i].equals(String.valueOf(s.charAt(0)))) {
                    s = s + symbols[i];
                } else {
                    s = s.substring(1);
                    s = s + symbols[i];

                    subStr = s.substring(1);
                    first = s.substring(0, 1);

                    if (subStr.contains(first)) {
                        do {
                            s = s.substring(1);
                            subStr = s.substring(1);
                            first = s.substring(0, 1);
                        } while (subStr.contains(first));
                    }

                }

                if (s.contains("a") && s.contains("b") && s.contains("c") && s.contains("d")) {
                    strings.add(s);
                }

            }
        }
        List<Integer> strLengths = new ArrayList<>();
        for (String string: strings) {
            strLengths.add(string.length());
        }
        Collections.sort(strLengths);


        System.out.println(strLengths.get(0));

    }

    public static int findIndex(String[] a, String target)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
