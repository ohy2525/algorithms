package 백준.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tot = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int hop = 0;

        for (int i = 0; i < cnt; i++) {

            String[]b = br.readLine().split(" ");

            int price = Integer.parseInt(b[0]);
            int count = Integer.parseInt(b[1]);

            int total  = price * count;

            hop += total;
        }

        if (hop == tot) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
