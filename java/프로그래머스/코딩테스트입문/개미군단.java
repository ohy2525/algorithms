package 프로그래머스.코딩테스트입문;

public class 개미군단 {
    public int solution(int hp) {
        int answer = 0;
        answer += hp / 5;
        hp %= 5;
        answer += hp / 3;
        hp %= 3;
        answer += hp / 1;

        return answer;
    }
}
