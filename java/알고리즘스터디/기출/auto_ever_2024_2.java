package 알고리즘스터디.기출;

public class auto_ever_2024_2 {
    public static void main(String[] args) {
        System.out.println(find(5, 2, 5, new int[][]{{4, 5}, {3, 4}, {2, 1}, {5, 7}, {1, 1}}));
    }

    private static int find(int n, int k, int m, int[][] supplies) {
        int result = 0;

        for (int kk = 0; kk < k; kk++) {
            int[][] dp = new int[n][m + 1];
            int[][] used = new int[n][m + 1];

            for (int j = supplies[0][0]; j <= m; j++) {
                dp[0][j] = supplies[0][1];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j];
                    used[i][j] = used[i - 1][j];

                    if (supplies[i][0] <= j && dp[i][j] < supplies[i][1] + dp[i - 1][j - supplies[i][0]]) {
                        dp[i][j] = supplies[i][1] + dp[i - 1][j - supplies[i][0]];
                        used[i][j] = i;
                    }
                }
            }

            result += dp[n - 1][m];
            int idx = m;
            while (idx > 0) {
                supplies[used[n - 1][idx]][1] = 0;
                idx -= supplies[used[n - 1][idx]][0];
            }
        }

        return result;
    }
}
