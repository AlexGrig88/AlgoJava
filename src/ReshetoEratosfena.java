import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReshetoEratosfena {

    public static void main(String[] args) {

       System.out.println(eratosfenNums(720));
    }


    //Алгоритм решета Эратосфена (нахождение простых чисел в диапазоне от 0 до max) O(nlog(n)) - сложность
    public static List<Integer> eratosfenNums(int max) {

        boolean[] arrBooleans = new boolean[max];
        Arrays.fill(arrBooleans, true);

        for (int i = 2; i * i < max; i++) {
            if (arrBooleans[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    arrBooleans[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < arrBooleans.length; i++) {
            if (arrBooleans[i]) primes.add(i);
        }

        return primes;
    }

}
