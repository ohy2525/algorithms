package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aInput[i]);
            b[i] = Integer.parseInt(bInput[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (long) a[i] * b[n - 1 - i];
        }

        System.out.println(ans);
    }
}
