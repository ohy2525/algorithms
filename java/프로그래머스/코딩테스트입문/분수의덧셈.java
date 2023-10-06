package 프로그래머스.코딩테스트입문;

public class 분수의덧셈 {
    public int[] solution(int number1, int denom1, int number2, int denom2) {
        int number = number1 * denom2 + number2 * denom1;
        int denom = denom1 * denom2;

        for (int i = denom; i > 0; i--) {
            if (number % i == 0 && denom % i == 0) {
                number /= i;
                denom /= i;
            }
            if (denom == 1) break;
        }
        int[] answer = {number, denom};
        return answer;
    }
}
