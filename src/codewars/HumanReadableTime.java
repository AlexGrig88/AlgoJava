package codewars;

public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(86399 % 60);
        System.out.println(makeReadable(86399));
    }

    public static String makeReadable(int seconds) {
        int h = seconds / 3600;
        int m = (seconds / 60) % 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
