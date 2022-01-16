package codewars;

import java.util.*;

public class DirReduction {

    public static void main(String[] args) {

        String[] arr = new String[] {"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"};

        System.out.println(Arrays.toString(dirReducBest(arr)));
        //System.out.println("hjhj".equals(null));
//        Deque<String> deque = new LinkedList<>();
//        System.out.println(deque.peekLast());
    }

    public static String[] dirReducBest(String[] arr) {

        Deque<String> deque = new LinkedList<>(); //works as Stack

        for (int i = 0; i < arr.length; i++) {
            String lastDir = deque.peekLast(); //если список пуст вернётся null
            switch (arr[i]) {
                case "NORTH":
                    if ("SOUTH".equals(lastDir)) deque.pollLast();
                    else deque.addLast(arr[i]);
                    break;

                case "SOUTH":
                    if ("NORTH".equals(lastDir)) deque.pollLast();
                    else deque.addLast(arr[i]);
                    break;

                case "WEST":
                    if ("EAST".equals(lastDir)) deque.pollLast();
                    else deque.addLast(arr[i]);
                    break;

                case "EAST":
                    if ("WEST".equals(lastDir)) deque.pollLast();
                    else deque.addLast(arr[i]);
                    break;

                default: break;
            }
        }

        return deque.toArray(new String[0]);

    }



    public static String[] dirReduc(String[] arr) {
        int oldlength = arr.length;
        int newlength = 0;
        while(newlength != oldlength){
            oldlength = arr.length;
            arr = reduc(arr);
            newlength = arr.length;
        }
        return arr;
    }

    public static String[] reduc(String[] arr){
        List<String> list = new ArrayList<String>();
        for(int i= 0; i<arr.length;i++){
            if(i != arr.length-1 && ((arr[i].equals("NORTH") && arr[i+1].equals("SOUTH")) || (arr[i].equals("SOUTH") && arr[i+1].equals("NORTH")))){
                i++;
            } else if(i != arr.length-1 && ((arr[i].equals("WEST") && arr[i+1].equals("EAST")) || (arr[i].equals("EAST") && arr[i+1].equals("WEST")))){
                i++;
            } else{
                list.add(arr[i]);
            }
        }
        String[] stockArr = new String[list.size()];
        stockArr = list.toArray(stockArr);
        return stockArr;
    }

}
