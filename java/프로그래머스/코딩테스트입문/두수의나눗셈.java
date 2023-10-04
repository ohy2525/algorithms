package 프로그래머스.코딩테스트입문;

public class 두수의나눗셈 {
    public int solution(int num1, int num2) {
        float v = (float) num1 / num2;
        return (int) (v * 1000);
    }
}
