package 알고리즘스터디.중급;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i <s.length(); i++) {
            int cur = s.charAt(i) - '0';
            int ten = (s.charAt(i - 1) - '0') * 10 + cur;

            if (cur != 0) {
                dp[i] += dp[i - 1];
            }

            if (ten >= 10 && ten <= 26) {
                dp[i] += (i >= 2) ? dp[i - 2] : 1;
            }
        }

        return dp[s.length() - 1];
    }
}
