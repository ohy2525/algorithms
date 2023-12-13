package 백준.브루트포스;

import java.io.*;

public class bj1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int ans = 0;
        for(int i = 1; i < n + 1; i++) {
            if (i < 100) {
                ans += 1;
            } else {
                int char1 = i / 100;
                int char2 = (i / 10) % 10;
                int char3 = i % 10;

                if ((char1 - char2) == (char2 - char3)) {
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
