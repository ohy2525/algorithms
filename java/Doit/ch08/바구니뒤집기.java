package Doit.ch08;

import java.io.*;

public class 바구니뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            while (start < end) {
                int tmp = arr[start - 1];
                arr[start - 1] = arr[end - 1];
                arr[end - 1] = tmp;
                start++;
                end--;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
