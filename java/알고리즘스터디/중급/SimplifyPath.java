package 알고리즘스터디.중급;

import java.util.ArrayDeque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if (s.equals("..")) {
                stack.pollLast();
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.addLast(s);
            }
        }

        if (stack.size() == 0) return "/";

        StringBuilder sb = new StringBuilder("/");
        for (String s : stack) {
            sb.append(s).append("/");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
