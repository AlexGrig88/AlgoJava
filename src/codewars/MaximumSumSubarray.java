package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-21, -21, 29, 14, -25, -10, 9, 1, 9, -25, -11, -14, -1, -27, -4, 2, -3, 7, -7, -17, 9, 1, 10, 25, -29, 6, -21, -7, 25, 0, 24, -4, -10, -19, -23, 18, -22, 3, -7, -23, -22, -1, -23, -10, 19, 10, -22, 19, -16, 17}));
    }

    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;
//        int[] copyArr = new int[arr.length];
//        System.arraycopy(arr, 0, copyArr, 0, arr.length);
//        Arrays.sort(copyArr);
//
//        if (copyArr[0] < 0 && copyArr[copyArr.length - 1] <= 0) return 0;
//        if (copyArr[0] >= 0 && copyArr[copyArr.length - 1] > 0) return Arrays.stream(copyArr).sum();

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (max <= 0) return 0;

        int maxSumSubarray = 0;

        int start = arr[0];
        for (int i = 0; i < arr.length; i++) {

            int right = i;
            int sum2 = arr[i];
            if (arr[i] < start) {
                start = arr[i];
                continue;
            }

            while (++right <= arr.length - 1) {
                sum2 += arr[right];
                if (sum2 > maxSumSubarray) maxSumSubarray = sum2;
            }
        }

        return maxSumSubarray;
    }
}
