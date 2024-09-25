package 프로그래머스;

import java.util.*;

public class 거리두기확인하기 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = bfs(places[i]);
        }

        return answer;
    }

    private int bfs(String[] place) {
        char[][] p = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                p[i] = place[i].toCharArray();
            }
        }

        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (p[i][j] == 'P') {
                    start.add(new int[]{i, j});
                }
            }
        }

        for (int [] s : start) {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[5][5];
            int[][] distance = new int[5][5];

            q.addLast(s);
            visited[s[0]][s[1]] = true;
            while (!q.isEmpty()) {
                int[] current = q.pollFirst();
                int y = current[0];
                int x = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[ny][nx]) {
                        if (p[ny][nx] == 'O') {
                            q.addLast(new int[]{ny, nx});
                            visited[ny][nx] = true;
                            distance[ny][nx] = distance[y][x] + 1;
                        }

                        if (p[ny][nx] == 'P' && distance[y][x] <= 1) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
}
