import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReshetoEratosfena {

    public static void main(String[] args) {
        System.out.println(factors(7775460));
       // System.out.println(Arrays.toString(eratosfenNums(7920)));
    }



    //Codewars (Lesson: Primes in numbers)
    //представить число, как произведение простых степенных множителей
    // (простые множители возводятся в степень)
    //решето эратосфена не нужно, т.к. мы избавляемся от непростых!!! чисел, когда многократно делим
    //на множитель didvider
    public static String factors(int n) {

        List<Integer> list = new ArrayList<>();
        int counter = 0, divider = 2;
        while(n > 1) {
            if (n % divider == 0) {
                n /= divider;
                ++counter;
            } else {
                if (counter > 0) {
                    list.add(divider);
                    list.add(counter);
                }
                counter = 0;
                divider++;
            }
        }
        list.add(divider);
        list.add(counter);

        String res = "(";
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i + 1) == 1)  { res += list.get(i) + ")("; continue; }
            res += list.get(i) + "**" + list.get(i + 1) + ")(";
        }

        return res.substring(0, res.length() - 1);

    }

    //Алгоритм решета Эратосфена (нахождение простых чисел в диапазоне от 0 до max) O(nlog(n)) - сложность
    public static List<Integer> eratosfenNums(int max) {

        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) list.add(i);
        }

        return list;
    }

}
