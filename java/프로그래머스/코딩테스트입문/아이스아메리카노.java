package 프로그래머스.코딩테스트입문;

public class 아이스아메리카노 {
    public int[] solution(int money) {
        return new int[]{(money / 5500), money % 5500};
    }
}
