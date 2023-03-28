package kar.urals.skb.kontur.summer2023.contest.task2;


import java.util.*;

// так и не решил

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nails = new int[n][2];
        for (int i = 0; i < n; i++) {
            nails[i][0] = scanner.nextInt();
            nails[i][1] = scanner.nextInt();
        }

        double maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (isRectangle(nails[i], nails[j], nails[k], nails[l])) {
                            double area = rectangleArea(nails[i], nails[j], nails[k], nails[l]);
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    // Функция, которая проверяет, являются ли 4 точки вершинами прямоугольника
    private static boolean isRectangle(int[] a, int[] b, int[] c, int[] d) {
        int abx = b[0] - a[0], aby = b[1] - a[1];
        int acx = c[0] - a[0], acy = c[1] - a[1];
        int adx = d[0] - a[0], ady = d[1] - a[1];

        return (abx * acx + aby * acy) == 0 && (abx * adx + aby * ady) == 0 && (acx * adx + acy * ady) == 0;
    }

    // Функция, которая вычисляет площадь прямоугольника по его вершинам
    private static double rectangleArea(int[] a, int[] b, int[] c, int[] d) {
        double ab = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
        double bc = Math.sqrt(Math.pow(c[0] - b[0], 2) + Math.pow(c[1] - b[1], 2));
        return ab * bc;
    }
}