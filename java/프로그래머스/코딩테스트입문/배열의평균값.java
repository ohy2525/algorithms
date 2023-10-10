package 프로그래머스.코딩테스트입문;

public class 배열의평균값 {
    public double solution(int[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }
}
