package arrays;

import java.util.HashSet;

public class Sudoku2 {
    boolean solution(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            HashSet<Integer> myX = new HashSet<Integer>();
            HashSet<Integer> myY = new HashSet<Integer>();
            for (int j = 0; j < grid[0].length; j++) {
                Character x = grid[i][j];
                Character y = grid[j][i];
                if (!x.equals(new Character('.'))) {
                    if (myX.contains(Character.getNumericValue(x))) return Boolean.FALSE;
                    else myX.add(Character.getNumericValue(x));
                }
                if (!y.equals(new Character('.'))) {
                    if (myY.contains(Character.getNumericValue(y))) return Boolean.FALSE;
                    else myY.add(Character.getNumericValue(y));
                }
            }
        }

        for (int i = 0; i < grid.length; i+=3) {
            char[][] matrix = new char[3][3];
            for (int j = 0; j < grid[0].length; j+=3) {
                if (i <= grid.length-3 && j <= grid.length-3) {
                    matrix[0][0] = grid[i][j];
                    matrix[0][1] = grid[i][j+1];
                    matrix[0][2] = grid[i][j+2];
                    matrix[1][0] = grid[i+1][j];
                    matrix[1][1] = grid[i+1][j+1];
                    matrix[1][2] = grid[i+1][j+2];
                    matrix[2][0] = grid[i+2][j];
                    matrix[2][1] = grid[i+2][j+1];
                    matrix[2][2] = grid[i+2][j+2];
                    if (!check(matrix)) return Boolean.FALSE;
                }

            }
        }

        return Boolean.TRUE;
    }

    boolean check(char[][] matrix) {
        HashSet<Integer> myXY = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Character xy = matrix[i][j];
                if (!xy.equals(new Character('.'))) {
                    if (myXY.contains(Character.getNumericValue(xy))) return Boolean.FALSE;
                    else myXY.add(Character.getNumericValue(xy));
                }

            }
        }
        return Boolean.TRUE;
    }

}
