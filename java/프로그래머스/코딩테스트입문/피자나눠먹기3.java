package 프로그래머스.코딩테스트입문;

public class 피자나눠먹기3 {
    public int solution(int slice, int n) {
        for (int i = 1; i <= 50; i++) {
            if (slice * i >= n) {
                return i;
            }
        }
        return 0;
    }
}
