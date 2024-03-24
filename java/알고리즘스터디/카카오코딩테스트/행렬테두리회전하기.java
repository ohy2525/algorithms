package 알고리즘스터디.카카오코딩테스트;

public class 행렬테두리회전하기 {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        int[][] map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int[] q : queries) {
            int sx = q[1] - 1, sy = q[0] - 1, ex = q[3] - 1, ey = q[2] - 1;
            int d = 0;

            int cache = map[sy][sx];
            int min = cache;
            int x = sx + dx[d], y = sy + dy[d];
            while (true) {
                if ((x > ex) || (y > ey) || (x < sx)) {
                    x -= dx[d]; y -= dy[d];
                    d++;
                    x += dx[d]; y += dy[d];
                }
                int next = map[y][x];
                min = Math.min(min, next);
                map[y][x] = cache;
                cache = next;
                if (x == sx && y == sy) break;
                x += dx[d];
                y += dy[d];
            }

            answer[idx++] = min;
        }

        return answer;
    }
}
