package codewars;

import java.util.HashMap;
import java.util.Map;

public class SnakesLadders {

    boolean playFirst = true;
    int scores1 = 0;
    int scores2 = 0;
    int[] laddersArr = {2, 38, 7, 14, 8, 31,
            15, 26, 28, 84, 21, 42, 36, 44, 51, 67, 78, 98, 71, 91, 87, 94};
    int[] snakesArr = {16, 6, 49, 11, 46, 25, 64, 60, 62, 19, 74, 53,
            89, 68, 92, 88, 95, 75, 99, 80};
    Map<Integer, Integer> map;
    boolean isWin = false;

    public SnakesLadders() {
        map = new HashMap<>();
        for (int i = 0; i < laddersArr.length;) {
            map.put(laddersArr[i++], laddersArr[i++]);
        }
        for (int i = 0; i < snakesArr.length;) {
            map.put(snakesArr[i++], snakesArr[i++]);
        }
    }

    public String play(int die1, int die2) {
       if (isWin) return "Game over!";

       int sum = die1 + die2;
       int playerNumber = playFirst ? 1 : 2;
       int scores = playFirst ? scores1 : scores2;
       scores += sum;
       if (scores == 100) {
           isWin = true;
           return String.format("Player %d Wins!\n", playerNumber);
       }
       if (scores > 100) {
           scores = 200 - scores;
       }

       if (map.containsKey(scores)) {
           scores = map.get(scores);
       }

        switch (playerNumber) {
            case 1: scores1 = scores;
                break;
            case 2: scores2 = scores;
                break;
        }
        if (die1 != die2) playFirst = !playFirst;
        return String.format("Player %d is on square %d", playerNumber, scores);
    }

    public static void main(String[] args) {
        SnakesLadders game = new SnakesLadders();
        System.out.println(game.play(1, 1));
        System.out.println(game.play(1, 5));
        System.out.println(game.play(6, 2));
        System.out.println(game.play(1, 1));
    }
}
