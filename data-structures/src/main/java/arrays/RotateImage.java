package arrays;

public class RotateImage {
    int[][] solution(int[][] a) {

        int[][] result = new int[a.length][a[0].length];

        int b = a.length;
        for (int i = 0; i < a.length; i++) {
            b--;
            for (int j = 0; j < a[0].length; j++) {
                result[j][b] = a[i][j];
            }
        }

        return result;
    }

}
