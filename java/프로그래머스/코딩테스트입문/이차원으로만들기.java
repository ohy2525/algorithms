package 프로그래머스.코딩테스트입문;

public class 이차원으로만들기 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int index=0;
        for(int i = 0; i < answer.length; i++) {
            int[] tmp = new int[n];
            for(int j = 0; j < n; j++) {
                tmp[j] = num_list[index];
                index++;
            }
            answer[i] = tmp;
        }
        return answer;
    }
}
