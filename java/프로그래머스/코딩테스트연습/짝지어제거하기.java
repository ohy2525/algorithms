package 프로그래머스.코딩테스트연습;

import java.util.*;

public class 짝지어제거하기 {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else if (stack.peekLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
