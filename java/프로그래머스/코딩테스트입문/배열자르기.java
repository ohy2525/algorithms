package 프로그래머스.코딩테스트입문;

public class 배열자르기 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1 + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers[num1 + i];
        }

        return answer;
    }
}
