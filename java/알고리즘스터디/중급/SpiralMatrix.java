package 알고리즘스터디.중급;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        while (ans.size() < m * n) {
            for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
                ans.add(matrix[r1][j]);
            for (int i = r1 + 1; i <= r2 - 1 && ans.size() < m * n; ++i)
                ans.add(matrix[i][c2]);
            for (int j = c2; j >= c1 && ans.size() < m * n; --j)
                ans.add(matrix[r2][j]);
            for (int i = r2 - 1; i >= r1 + 1 && ans.size() < m * n; --i)
                ans.add(matrix[i][c1]);
            ++r1;
            ++c1;
            --r2;
            --c2;
        }

        return ans;
    }
}
