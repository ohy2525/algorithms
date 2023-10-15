package 프로그래머스.코딩테스트입문;

public class 양꼬치 {
    public int solution(int n, int k) {
        int answer = 0;
        answer += 12000 * n + 2000 * (k - n / 10);
        return answer;
    }
}
