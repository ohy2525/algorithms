package 프로그래머스.코딩테스트연습.스택큐;

import java.util.*;

public class 기능개발 {
    public Stack<Integer> solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            day[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        for (int i = 1; i < day.length; i++) {
            if (day[i] < day[i - 1]) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
            }
        }

        return stack;
    }
}
