package 백준.일반수학1;

import java.io.*;
import java.util.*;

public class 달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        br.close();
        int answer = (int) Math.ceil((double) (v - a) / (a - b)) + 1;
        System.out.println(answer);
    }
}
