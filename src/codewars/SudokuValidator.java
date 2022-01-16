package codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static void main(String[] args) {
        System.out.println(check(sudokuB));
        sudokuB[0][0]++;
        sudokuB[1][1]++;
        sudokuB[0][1]--;
        sudokuB[1][0]--;
        System.out.println(check(sudokuB));
        sudokuB[0][0]--;
        sudokuB[1][1]--;
        sudokuB[0][1]++;
        sudokuB[1][0]++;
        sudokuB[4][4] = 0;
        System.out.println(check(sudokuB));
    }

    public static int[][] sudokuB = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public static boolean check(int[][] sudoku) {

        Set<Integer> setHoriz = new HashSet<>();
        Set<Integer> setVert = new HashSet<>();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) return false;
                setHoriz.add(sudoku[i][j]);
                setVert.add(sudoku[j][i]);
            }
            if (setHoriz.size() != 9 || setVert.size() != 9) return false;
            setHoriz.clear();
            setVert.clear();
        }

        Set<Integer> setBlock = new HashSet<>();
        int stepI = 0, stepJ = 0;
        while (stepI < 9) {
            for (int i = 0 + stepI; i < 3 + stepI; i++) {
                for (int j = 0 + stepJ; j < 3 + stepJ; j++) {
                    setBlock.add(sudoku[i][j]);
                }
            }
            if (setBlock.size() != 9) return false;
            setBlock.clear();
            stepJ += 3;
            if (stepJ == 9) {
                stepJ = 0;
                stepI += 3;
            }
        }

        return true;
    }
}
