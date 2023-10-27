package Doit.ch08;

import java.io.*;
import java.util.*;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (arr[x + j][y + k] == 0) {
                        arr[x + j][y + k] = 1;
                        answer++;
                    }
                }
            }
        }
        br.close();
        System.out.println(answer);
    }
}
