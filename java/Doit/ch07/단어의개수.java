package Doit.ch07;

import java.io.*;

public class 단어의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        br.close();
        int answer = 0;
        input = input.trim();
        if (!input.isEmpty()) {
            answer = input.split(" ").length;
        }
        System.out.println(answer);
    }
}
