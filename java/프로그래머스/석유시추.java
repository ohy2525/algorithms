package 프로그래머스;

import java.util.*;

public class 석유시추 {
    public int solution(int[][] land) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] oilCnt = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    visited[i][j] = true;
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});

                    Set<Integer> colSet = new HashSet<>();
                    int cnt = 0;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        colSet.add(y);
                        cnt++;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }

                    for (int col : colSet) {
                        oilCnt[col] += cnt;
                    }
                }
            }
        }

        int answer = 0;
        for (int cnt : oilCnt) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
