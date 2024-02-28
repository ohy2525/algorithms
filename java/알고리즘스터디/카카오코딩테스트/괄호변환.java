package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 괄호변환 {
    public static String solution(String p) {
        if (isValid(p)) return p;
        return dfs(p);

    }

    private static String dfs(String p) {
        if (p.length() == 0) return p;
        StringBuilder sb = new StringBuilder();

        String u = "", v = "";
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(') cnt1++;
            else cnt2++;

            if (((cnt1 > 0) && (cnt2 > 0)) && (cnt1 == cnt2)) {
                u = p.substring(0, i + 1);
                if (i < p.length() - 1) v = p.substring(i + 1, p.length());
                break;
            }
        }

        if (isValid(u)) return u + dfs(v);

        sb.append('(');
        sb.append(dfs(v));
        sb.append(')');
        u = u.substring(1, u.length() - 1);
        u = u.replace('(', '.');
        u = u.replace(')', '(');
        u = u.replace('.', ')');
        sb.append(u);
        return sb.toString();
    }

    public static int getSplitIndex(String p) {
        int idx = 0;
        char[] charArray = p.toCharArray();
        ArrayDeque<Character> q = new ArrayDeque<>();
        q.addLast(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == q.peekLast()) {
                q.addLast(charArray[i]);
            } else {
                q.removeLast();
            }

            if (q.isEmpty()) {
                idx = i;
                break;
            }
        }

        return idx + 1;
    }

    public static boolean isValid(String p) {
        ArrayDeque<Character> q = new ArrayDeque<>();

        for (char c : p.toCharArray()) {
            if (c == ')') {
                if (q.isEmpty()) return false;
                q.removeLast();
            } else {
                q.addLast(c);
            }
        }

        if (q.isEmpty()) return true;
        return false;
    }


    // study
    public String solution2(String p) {
        if (p.length() == 0) return "";

        int sum = 0, idx = 0;
        for (idx = 0; idx < p.length(); idx++) {
            sum += p.charAt(idx) == '(' ? 1 : -1;
            if (sum == 0) {
                break;
            }
        }

        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if (isValid2(u)) {
            return u + solution(v);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('(').append(solution(v)).append(')');
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }

        return sb.toString();
    }

    private boolean isValid2(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sum++;
            } else {
                if (sum == 0) return false;
                sum--;
            }
        }

        return true;
    }

}
