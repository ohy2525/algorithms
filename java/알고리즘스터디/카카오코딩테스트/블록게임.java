package 알고리즘스터디.카카오코딩테스트;

public class 블록게임 {
    int N;
    int[][] Board;

    public int solution(int[][] board) {
        N = board.length;
        Board = board;
        int answer = 0;
        int cnt;

        do {
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i <= N - 2 && j <= N - 3 && find(i, j, 2, 3)) {
                        cnt++;
                    } else if (i <= N - 3 && j <= N - 2 && find(i, j, 3, 2)) {
                        cnt++;
                    }
                }
            }
            answer += cnt;
        } while (cnt != 0);

        return answer;
    }

    private boolean find(int row, int col, int h, int w) {
        int emptyCnt = 0;
        int lastValue = -1;
        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                if (Board[r][c] == 0) {
                    if (!canFill(r, c)) return false;
                    if (++emptyCnt > 2) return false;
                } else {
                    if (lastValue != - 1 && lastValue != Board[r][c]) return false;
                    lastValue = Board[r][c];
                }
            }
        }

        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                Board[r][c] = 0;
            }
        }

        return true;
    }

    private boolean canFill(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (Board[i][col] != 0) return false;
        }

        return true;
    }
}
