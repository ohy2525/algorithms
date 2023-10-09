package 프로그래머스.코딩테스트입문;

public class 피자나눠먹기1 {
    public int solution(int n) {
        if (n % 7 == 0) {
            return n / 7;
        }
        return n / 7 + 1;
    }
}
