package codewars;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class HammingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            System.out.println(n + "-е" + " число Хэмминга = " + hamming3(n));
            n = scanner.nextInt();
        }
//        int[] candidates = {22, 3, 5, 2, 23, 13};
//        int nextN = Arrays.stream(candidates).min().getAsInt();
//        System.out.println(nextN);
    }

    //самый понятный алгоритм
    public static long hamming3(int n) {
        if (n <= 0) return -1;
        TreeSet<Long> ts = new TreeSet<>(Arrays.asList(2L, 3L, 5L));
        long smallest = 1;
        long start = System.currentTimeMillis();
        for (int i = 1; i < n; i++) {
            smallest = ts.pollFirst();
            ts.add(smallest * 2);
            ts.add(smallest * 3);
            ts.add(smallest * 5);
        }
        System.out.println("size = " + ts.size());
        System.out.println("performance = " + (System.currentTimeMillis() - start));
        return smallest;
    }

    public static long hammingBest(int n) {
        long[] h = new long[n];
        h[0] = 1;
        long a = 2, b = 3, c = 5;
        int i = 0, j = 0, k = 0;

        long start = System.currentTimeMillis();
        for (int index = 1; index < n; index++) {
            h[index] = Math.min(a, Math.min(b, c));
            if (h[index] == a) a = 2 * h[++i];
            if (h[index] == b) b = 3 * h[++j];
            if (h[index] == c) c = 5 * h[++k];
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("c = " + c);
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("performance = " + (System.currentTimeMillis() - start));
        return h[n - 1];
    }


    //bad performance O(n^2)
    public static long hamming2(int n) {

        if (n > 0 && n < 7) return n;
        int counterHam = 6;
        long numberOfHam = 6;
        while (counterHam < n) {
            numberOfHam++;
            if (isNumberOfHamming(numberOfHam)) {
                counterHam++;
            }
        }
        return numberOfHam;
    }

    private static boolean isNumberOfHamming(long numberOfHam) {
        long res = numberOfHam;

        while (res != 1) {
            if (res % 2 == 0)  res /= 2;
            else if (res % 3 == 0)  res /= 3;
            else if (res % 5 == 0)  res /= 5;
            else return false;
        }
        return true;
    }
}
