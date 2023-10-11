package 프로그래머스.코딩테스트입문;


public class 배열뒤집기 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - i - 1];
        }

        return answer;
    }
}
