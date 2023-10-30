package 알고리즘스터디.중급;

import java.util.*;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.addLast(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    arr[i] = '_';
                } else {
                    stack.pollLast();
                }
            }
        }

        for (Integer i : stack) {
            arr[i] = '_';
        }

        return new String(arr).replace("_", "").toString();
    }
}
