package codewars;

public class PigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("Hello world !"));
    }

    public static String pigIt(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
