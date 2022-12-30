public class MergeSortClass {

    private static int[] merge(int[] a, int[] b) {

        int aLen = a.length;
        int bLen = b.length;

        int[] res = new int[aLen + bLen];
        int i = 0, j = 0, k = 0;
        while (i < aLen && j < bLen) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < aLen) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < bLen) {
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }


    public static int[] mergeSort(int[] arr) {
        if (arr == null) {
            System.out.println("Array is empty!");
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }

        // делим исходный массив на 2 подмассива пополам
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - arr.length / 2);

        return merge(mergeSort(left), mergeSort(right));
    }

}
