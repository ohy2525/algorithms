package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1] + dp[i][j], dp[i - 1][2] + dp[i][j]);
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0] + dp[i][j], dp[i - 1][2] + dp[i][j]);
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][0] + dp[i][j], dp[i - 1][1] + dp[i][j]);
                }
            }
        }

        int ans = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        System.out.println(ans);
    }
}
