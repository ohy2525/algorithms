package 알고리즘스터디.중급;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {

        int answer = 0;
        int check = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                check++;
            } else {
                if (check > 0) {
                    check--;
                } else {
                    answer++;
                }
            }
        }

        return answer + check;
    }
}
