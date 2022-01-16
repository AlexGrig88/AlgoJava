package codewars;

import java.util.*;

public class Mixing {

    public static void main(String[] args) {



        String s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &";
        String s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&";
        System.out.println(mix(s1, s2));

        System.out.println();
        String s3 = "my&friend&Paul has heavy hats! &";
        String s4 = "my friend John has many many friends &";
        System.out.println(mix(s3, s4));

        System.out.println();
        String s5 = "Are the kids at home? aaaaa fffff";
        String s6 = "Yes they are here! aaaaa fffff";
        System.out.println(mix(s5, s6));


    }

    public static String mix(String s1, String s2) {

        if (s1.equals(s2)) return "";

        Map<Character, Integer> mapS1 = parseAsCounterLettersAsc(s1);
        Map<Character, Integer> mapS2 = parseAsCounterLettersAsc(s2);

        List<String> list = new ArrayList<>();

        for (int i = 'a'; i <= 'z' ; i++) {
            char ch = (char)i;
            int count1 = mapS1.get(ch);
            int count2 = mapS2.get(ch);
            if (count1 > count2 && count1 != 1) {
                list.add("1:" + String.valueOf(ch).repeat(count1));

            } else if (count2 > count1 && count2 != 1) {
                list.add("2:" + String.valueOf(ch).repeat(count2));

            } else if (count2 == count1 && count2 > 1) {
                list.add("=:" + String.valueOf(ch).repeat(count1));
            }
        }

        list.sort((str1, str2) -> {
            if (str1.length() != str2.length()) { return str2.length() - str1.length(); }
            else { return str1.compareTo(str2); }
        });

        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item + "/");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    //не используется
    public static String repeatChars(char ch, int times) {
        char[] arr = new char[times];
        for (int i = 0; i < times; i++) {
            arr[i] = ch;
        }
        return new String(arr);
    }


    public static Map<Character, Integer> parseAsCounterLettersAsc(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 'a'; i <= 'z'; i++) {
            map.put((char)i, 0);
        }

        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                map.compute(ch, (character, counter) -> counter + 1);
            }
        }

        return map;
    }

//    static class Triple {
//        private int times;
//        private String line;
//        private String symbolId;
//        public Triple(int t, String l, String id) { times = t; line = l; symbolId = id; }
//        public int getTimes() { return times; }
//        public String getLine() {
//            return symbolId + ":" + line;
//        }
//        public String getSymbolId() { return symbolId; }
//    }

}
