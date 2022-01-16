package codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PickPeaks {

    public static void main(String[] args) {

        int[] arr = new int[] {0, 11, 6, 19, 17, 17, 15, 11, 12, 5, 10, -4, 3, 12, 16, 11, 10, 17, 12, -2, 17};
        Map<String,List<Integer>> map = getPeaksBest(arr);
        //Map<String,List<Integer>> map = getPeaks(arr);
        List<Integer> listPos = map.get("pos");
        List<Integer> listPeaks = map.get("peaks");
        System.out.print("pos: ");
        for (Integer pos : listPos) {
            System.out.print(pos + ", ");
        }

        System.out.print("\npeaks: ");
        for (Integer peak : listPeaks) {
            System.out.print(peak + ", ");
        }
    }

    public static Map<String,List<Integer>> getPeaks(int[] arr) {

        //To do: определить, что начали с плато и оно не есть максимум
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("pos", new ArrayList<>());
        map.put("peaks", new ArrayList<>());

        if (arr.length < 2) return map;

        int dir1 = 0, dir2 = 0, coordPlato = 0;
        boolean isPlato = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                isPlato = false; // если после плато, нам пришлось подниматься, то это дно
                dir1 = dir2;
                dir2 = 1;
            } else if (arr[i + 1] < arr[i]) {
                dir1 = dir2;
                dir2 = -1;
            } else {
                if (!isPlato) {
                    isPlato = true;
                    coordPlato = i;
                }
                dir1 = dir2;
            }

            if (dir1 == 1 && dir2 == -1) {
                //если мы начали идти с плато, то это не может быть пиком - coordPlato != 0
                if (isPlato && coordPlato != 0) {
                    map.get("pos").add(coordPlato);
                    isPlato = false;
                } else {
                    map.get("pos").add(i);
                }
                map.get("peaks").add(arr[i]);
            }

        }


        return map;
    }

    //Best practice
    public static Map<String,List<Integer>> getPeaksBest(int[] arr) {

        Map<String,List<Integer>> ans = new HashMap<String,List<Integer>>() {{
            put("pos",   new ArrayList<Integer>() );
            put("peaks", new ArrayList<Integer>() );
        }};
        int posMax = 0;
        boolean isMovingUp = false; //движение по восходящей

        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > arr[i - 1]) {
                isMovingUp = true;
                posMax = i;
            }
            if (isMovingUp && arr[i] < arr[i - 1]) {
                isMovingUp = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
    }
}