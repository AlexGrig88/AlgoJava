package testsClasses;

import java.time.Instant;
import java.time.ZonedDateTime;

public class DateTimeDemo {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        Instant instant = Instant.now();
        System.out.println(instant);
    }

}
