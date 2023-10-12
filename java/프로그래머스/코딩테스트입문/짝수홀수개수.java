package 프로그래머스.코딩테스트입문;

public class 짝수홀수개수 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int num1 = 0;
        int num2 = 0;
        for (int num : num_list) {
            if (num % 2 == 1) {
                num2++;
            } else {
                num1++;
            }
        }
        answer[0] = num1;
        answer[1] = num2;
        return answer;
    }
}
