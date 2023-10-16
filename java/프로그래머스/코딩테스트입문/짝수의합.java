package 프로그래머스.코딩테스트입문;

public class 짝수의합 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
