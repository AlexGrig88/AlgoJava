package codewars;

import java.util.Scanner;

public class NumberOfTrailingZerosFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number for calculate factorial: ");
        int n = scanner.nextInt();
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        System.out.println("result = " + res);
    }
}
