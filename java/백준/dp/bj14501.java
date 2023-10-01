package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            t[i] = a;
            p[i] = b;
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int k = i + t[i] - 1;
            if (k >= n) {
                continue;
            }
            if (i == 0) {
                dp[k] = p[0];
            } else {
                int maxVal = 0;
                for (int j = 0; j < i; j++) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
                dp[k] = Math.max(dp[k], maxVal + p[i]);
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        System.out.println(maxProfit);
    }
}