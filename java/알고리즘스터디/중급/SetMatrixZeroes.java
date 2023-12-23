package 알고리즘스터디.중급;

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> setM = new HashSet<>();
        HashSet<Integer> setN = new HashSet<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setM.add(i);
                    setN.add(j);
                }
            }
        }

        for (int i : setM) {
            matrix[i] = new int[n];
        }

        for (int j : setN) {
            for (int k = 0; k < m; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}
