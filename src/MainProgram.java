import java.util.Arrays;
import java.util.Random;

public class MainProgram {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = {2, 45, 21, 6, 8, 98 , 66, 23, 3, 4};
//        for (int i = 0; i < arr.length - 1; i++) {
//            arr[i] = rand.nextInt(10) + 5;
//        }
//        arr[arr.length - 1] = 5;
        long start = System.currentTimeMillis();
        //System.out.println("Before sort:");
        //System.out.println(Arrays.toString(arr));
        int target = 98;

        //BubbleSortClass.bubbleSort(arr);

        //InsertionSortClass.insertionSort(arr);
        //SelectionSortClass.selectionSort(arr);
        //MergeSortClass.mergeSort(arr);
        Arrays.sort(arr);



        //System.out.println("After sort:");
        //System.out.println(Arrays.toString(arr));
        System.out.println("BinarySearch: " + BinarySearchClass.binarySearch(arr, target));

        int a = 18, b = 30;
        System.out.println("GCD = " + GCD.gcd(a, b));


        System.out.println("Прошло милиссекунд: " + (System.currentTimeMillis() - start));
    }
}
