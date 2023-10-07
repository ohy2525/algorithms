package 프로그래머스.코딩테스트입문;

public class 배열두배만들기 {
    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        
        return numbers;
    }
}
