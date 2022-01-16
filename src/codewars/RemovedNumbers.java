package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RemovedNumbers {

    public static void main(String[] args) {

        boolean hasResult = false;

//        for (int i = 10; i < 30; i++) {
//            List<long[]> list = removNb(i);
//            for (long[] arr : list) {
//                if (!hasResult) System.out.println("n = " + i);
//                hasResult = true;
//                System.out.println(Arrays.toString(arr));
//            }
//            if (hasResult) System.out.println("===============================");
//            hasResult = false;
//        }

        for (int i = 26; i < 150; i++) {
            List<long[]> list = removNb2(i);
            for (long[] arr : list) {
                if (!hasResult) System.out.println("n = " + i);
                hasResult = true;
                System.out.println(Arrays.toString(arr));
            }
            if (hasResult) System.out.println("+++++++++++++++++++++++++++++++++++++");
            hasResult = false;
        }


//        List<long[]> list2 = removNb2(n);
//        for (long[] arr : list2) {
//            System.out.println(Arrays.toString(arr));
//        }

    }

    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<long[]>();
        long total = (n*(n+1))/2;

        for (int b=1; b <= n+1; b++) {
            long a = (total-b) / (b+1);
            if (a < n && a*b == total-a-b) {
                result.add(new long[] {b, a});
            }
        }
        return result;
    }


    public static List<long[]> removNb2(long n) {

        long sum = Stream.iterate(1L, i -> i + 1L).limit(n).mapToLong(Long::longValue).sum();
        System.out.println("sum =  " + sum );

        List<long[]> result = new ArrayList<long[]>();
        long sequence_sum = n * (n + 1) / 2;
        for (long x = 1; x <= n; x++) {
            long y = (sequence_sum - x) / (x + 1);
            if (y <= n && x * y == sequence_sum - x - y) {
                result.add(new long[] {x, y});
            }
        }
        return result;
    }

}
