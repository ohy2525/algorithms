package 백준.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = new int[N];

        while (M > 0) {
            String[] tmp = br.readLine().split(" ");
            int i = Integer.parseInt(tmp[0]);
            int j = Integer.parseInt(tmp[1]);
            int k = Integer.parseInt(tmp[2]);

            for (int t = i - 1; t < j; t++) {
                arr[t] = k;
            }
            M--;
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
            if (!(k == arr.length - 1)) {
                System.out.print(" ");
            }
        }
    }
}
