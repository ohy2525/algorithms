package Doit.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표값2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
        }
        br.close();

        Arrays.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr[2]);

    }
}
