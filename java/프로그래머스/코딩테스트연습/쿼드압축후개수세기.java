package 프로그래머스.코딩테스트연습;

public class 쿼드압축후개수세기 {
    static int[][] arr;
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        this.arr = arr;
        int n = arr.length;
        dfs(0, 0, n, n);
        return answer;
    }

    public void dfs(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 1) {
            answer[arr[x1][y1]]++;
            return;
        }

        int cnt0 = 0, cnt1 = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] == 0) {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }

        if (cnt0 == 0 || cnt1 == 0) {
            answer[0] += cnt1 == 0 ? 1 : 0;
            answer[1] += cnt0 == 0 ? 1 : 0;
            return;
        }

        dfs(x1, y1,  (x1 + x2) / 2, (y1 + y2) / 2);
        dfs(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
        dfs((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
        dfs((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
    }
}
