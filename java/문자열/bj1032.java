package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();
        int a_len = a.length;

        for (int i = 0; i < n - 1; i++) {
            char[] b = br.readLine().toCharArray();
            for (int j = 0; j < a_len; j++) {
                if (a[j] != b[j]) {
                    a[j] = '?';
                }
            }
        }

        System.out.println(new String(a));
    }
}
