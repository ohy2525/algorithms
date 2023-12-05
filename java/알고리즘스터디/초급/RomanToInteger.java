package 알고리즘스터디.초급;

public class RomanToInteger {

    public int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = getNumber(c);

            if (i == s.length() - 1) {
                answer += num;
                continue;
            }

            int nextNum = getNumber(s.charAt(i + 1));
            if (num < nextNum) {
                answer -= num;
            } else {
                answer += num;
            }
        }

        return answer;
    }

    private int getNumber(char c) {
        switch (c) {
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 1;
        }
    }
}
