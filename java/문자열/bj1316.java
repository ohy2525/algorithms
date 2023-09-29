package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] arr = new boolean[26];
            boolean flag = true;

            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                if (arr[index]) {
                    if (word.charAt(j - 1) != word.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                arr[index] = true;
            }
            if (flag) result++;
        }
        br.close();

        System.out.println(result);
    }
}
