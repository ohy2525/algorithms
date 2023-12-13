package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1182 {
    static int n, s;
    static int ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dfs(0, 0);

        System.out.println(s == 0 ? ans - 1 : ans);
    }

    private static void dfs(int i, int sum) {
        if (i == n) {
            if (sum == s) {
                ans++;
            }
            return;
        }

        dfs(i + 1, sum + arr[i]);
        dfs(i + 1, sum);
    }
}
