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
                    if (find(i, j, 2, 3)) {
                        cnt++;
                    } else if (find(i, j, 3, 2)) {
                        cnt++;
                    }
                }
            }
            answer += cnt;
        } while (cnt != 0):
        return answer;
    }

    private boolean find(int row, int col, int h, int w) {
        int emptyCnt = 0;
        int lastValue = -1;
        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                if (Board[r][c] == 0) {
                    
                }
            }
        }
    }
}
