package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] six = new int[m];
        int[] one = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            six[i] = a;
            one[i] = b;
        }

        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            minSix = Math.min(minSix, six[i]);
            minOne = Math.min(minOne, one[i]);
        }

        int ans = Math.min(minSix * (n / 6 + 1), Math.min(minSix * (n / 6) + minOne * (n % 6), minOne * n));

        System.out.println(ans);
    }
}