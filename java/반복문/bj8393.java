package 반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8393 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += i;
        }
        System.out.println(ans);
    }
}
