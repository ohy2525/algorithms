package 프로그래머스.코딩테스트연습;

import java.util.*;

public class 괄호회전하기 {
    static int answer = 0;

    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb = sb.append(sb.charAt(0));
            sb = sb.deleteCharAt(0);
            validCheck(sb.toString());
        }

        return answer;
    }

    private void validCheck(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.addLast(c);
            } else if (stack.isEmpty()) {
                return;
            } else if (c == ']' && stack.peekLast() == '[') {
                stack.pollLast();
            } else if (c == '}' && stack.peekLast() == '{') {
                stack.pollLast();
            } else if (c == ')' && stack.peekLast() == '(') {
                stack.pollLast();
            } else {
                return;
            }
        }

        if (stack.isEmpty()) {
            answer++;
        }
    }
}
