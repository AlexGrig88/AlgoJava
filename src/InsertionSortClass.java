public class InsertionSortClass {
    //O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // т.к. мы можем выйти так, что j может стать равным -1
            // поэтому надо сделать шаг вперед
            arr[j + 1] = current;

        }
    }
}
