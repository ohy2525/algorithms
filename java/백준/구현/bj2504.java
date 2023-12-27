package 백준.구현;

import java.io.*;
import java.util.*;

public class bj2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        int answer = 0;
        int cnt = 1;
        boolean flag = false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.addLast(c);
                cnt *= 2;
            } else if (c == '[') {
                stack.addLast(c);
                cnt *= 3;
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peekLast() != '(') {
                        flag = true;
                        break;
                    } else if (input.charAt(i - 1) == '(') {
                        answer += cnt;
                    }
                    stack.removeLast();
                    cnt /= 2;
                } else {
                    if (stack.isEmpty() || stack.peekLast() != '[') {
                        flag = true;
                        break;
                    } else if (input.charAt(i - 1) == '[') {
                        answer += cnt;
                    }
                    stack.removeLast();
                    cnt /= 3;
                }
            }
        }

        if (flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
