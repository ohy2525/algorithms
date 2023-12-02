package 백준.이분탐색;

import java.util.*;
import java.io.*;

public class bj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        
        long left = 1;
        long right = Arrays.stream(lines).max().getAsInt();
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for (int line : lines){
                cnt += line / mid;
            }
            
            if (cnt < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(right);
    }
}
