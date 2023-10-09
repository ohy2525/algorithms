package 프로그래머스.코딩테스트입문;

public class 피자나눠먹기2 {
    public int solution(int n) {
        int answer = 1;
        while (!(6 * answer % n == 0)) {
            answer++;
        }
        return answer;
    }
}
