package 프로그래머스.코딩테스트연습.스택큐;

import java.util.*;

public class 같은숫자는싫어 {
    public Stack<Integer> solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            if(stack.size() == 0 || stack.peek() != num){
                stack.push(num);
            }
        }

        return stack;
    }
}
