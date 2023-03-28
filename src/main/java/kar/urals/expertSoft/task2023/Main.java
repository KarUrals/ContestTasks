package kar.urals.expertSoft.task2023;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(3);
        a.add(5);

        b.add(2);
        b.add(6);
        b.add(8);

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < a.size() && bIndex < b.size()) {
            if (a.get(aIndex) < b.get(bIndex)) {
                aIndex++;
            } else {
                a.add(aIndex, b.get(bIndex));
                aIndex++;
                bIndex++;
            }
        }

        while (bIndex < b.size()) {
            a.add(b.get(bIndex));
            bIndex++;
        }

        System.out.println(a);
        System.out.println(b);
    }

}
