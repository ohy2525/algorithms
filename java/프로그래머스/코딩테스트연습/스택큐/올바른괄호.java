package 프로그래머스.코딩테스트연습.스택큐;

import java.util.*;

public class 올바른괄호 {
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}
