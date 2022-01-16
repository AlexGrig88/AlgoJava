package codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeWars {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(hexStringToRGB("#beaded")));
        System.out.println(Integer.parseInt("10", 16));
    }

    public static int[] hexStringToRGB(String hex) {

        Map<String, Integer> map = Map.of(
                "A", 10,
                "B", 11,
                "C", 12,
                "D", 13,
                "E", 14,
                "F", 15
                );


        int[] results = {0 , 0, 0};

        for (int i = 1, j = 0; i < hex.length(); ++i) {
            String ch = Character.toString(hex.charAt(i)).toUpperCase();
            int current = 0;
            if (map.containsKey(ch))
                current = map.get(ch);
            else
                current = Integer.parseInt(ch);
            if (i % 2 != 0)
                results[j] += current * 16;
            else
                results[j++] += current;
        }

        return results;
    }
}
