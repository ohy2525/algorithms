package 프로그래머스;

public class 양궁대회 {
    static int[] answer;
    static int result;
    static int[] info;

    public int[] solution(int n, int[] apeach) {
        answer = new int[11];
        result = 0;
        info = apeach;

        dfs(10, n, new int[11]);

        return result != 0 ? answer : new int[]{-1};
    }

    private void dfs(int idx, int left, int[] ryan) {
        if (idx == -1 && left > 0) {
            return;
        }
        if (left == 0) {
            int s = score(ryan);
            if (result < s) {
                answer = ryan.clone();
                result = s;
            }
            return;
        }

        for (int i = left; i >= 0; i--) {
            ryan[idx] = i;
            dfs(idx - 1, left - i, ryan);
            ryan[idx] = 0;
        }
    }

    public static int score(int[] ryan) {
        int s = 0;
        for (int i = 0; i < 11; i++) {
            if (ryan[i] == 0 && info[i] == 0) continue;

            if (ryan[i] > info[i]) {
                s += 10 - i;
            } else {
                s -= 10 - i;
            }
        }

        return s;
    }
}
