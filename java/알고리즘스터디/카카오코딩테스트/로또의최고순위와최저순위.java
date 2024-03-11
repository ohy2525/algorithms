package 알고리즘스터디.카카오코딩테스트;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            } else {
                for (int num : win_nums) {
                    if (lotto == num) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        answer[0] = cnt + zeroCnt == 0 ? 6 : 7 - (cnt + zeroCnt);
        answer[1] = cnt == 0 ? 6 : 7 - cnt;

        return answer;
    }
}
