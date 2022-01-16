import java.util.Arrays;

public class BinarySearchClass {
    public static int binarySearch(int[] arr, int number) {
        int left = 0, right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (number > arr[mid]) {
                left = mid + 1;
            } else if (number < arr[mid]) {
                right = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
