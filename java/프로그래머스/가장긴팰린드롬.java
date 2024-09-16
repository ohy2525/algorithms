package 프로그래머스;

public class 가장긴팰린드롬 {
    public static int solution(String s) {
        if (s == null || s.length() < 1) return 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = getLength(s, i, i);
            int len2 = getLength(s, i, i + 1);
            maxLen = Math.max(maxLen, Math.max(len1, len2));
        }
        return maxLen;
    }

    private static int getLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }return right - left - 1;
    }

}
