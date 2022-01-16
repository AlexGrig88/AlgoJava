package codewars;

import java.util.Arrays;
import java.util.Scanner;

public class ProdFib {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        while (p != 100) {
            long[] res = productFib(p);
            System.out.println(Arrays.toString(res));
            p = scanner.nextLong();
        }

    }

    public static long[] productFib(long prod) {

        if (prod == 0) return new long[] {0, 1, 1};
        if (prod == 1) return new long[] {1, 1, 1};
        long n1 = 0, n2 = 1;
        long next = 0;
//        System.out.print(n1 + "\n" + n2 + "\n");
        for (int i = 2; ; i++) {
            next = n2 + n1;
//            System.out.println(next);
//            System.out.println("F(n) * F(n+1) = " + n2 * next);
            if (n2 * next == prod) {
                return new long[] {n2, next, 1};
            } else if (n2 * next > prod){
                return new long[] {n2, next, 0};
            }
            n1 = n2;
            n2 = next;
        }
    }
}
