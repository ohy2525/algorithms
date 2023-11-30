package 백준.그리디;

import java.util.*;
import java.io.*;

public class bj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        int answer = 0;
        while(pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            pq.add(tmp);
            answer += tmp;
        }

        System.out.println(answer);
    }
}
