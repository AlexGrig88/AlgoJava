package testsClasses;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(5, "kdcm");
        map.put(3, "kdcm3");
        map.put(4, "kdcm4");
        map.put(6, "kdcm4");
        map.put(8, "kdcm");
        map.put(12, "kdcm");
        map.put(13, "kdcm");
        map.put(23, "kdcm");
        map.put(243, "kdcm");
        map.put(21, "kdcm");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
