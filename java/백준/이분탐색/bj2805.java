package 백준.이분탐색;

import java.util.*;
import java.io.*;

public class bj2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lengths = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int left = 0;
        int right = Arrays.stream(lengths).max().getAsInt();
        int answer = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long sum = 0;
            for (int length : lengths) {
                if (length > mid) {
                    sum += (length - mid);
                }
            }

            if (sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(answer);
    }
}
