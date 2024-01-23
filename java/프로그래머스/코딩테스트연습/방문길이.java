package 프로그래머스.코딩테스트연습;

import java.util.*;

public class 방문길이 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(String dirs) {
        String dir = "UDRL";
        Set<String> visited = new HashSet<>();
        int answer = 0;
        int x = 0, y = 0;
        for (char c : dirs.toCharArray()) {
            int nx = x + dx[dir.indexOf(c)];
            int ny = y + dy[dir.indexOf(c)];
            if (nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5) {
                String tmp1 = x + " " + y + " " + nx + " " + ny;
                String tmp2 = nx + " " + ny + " " + x + " " + y;
                if (!visited.contains(tmp1) && !visited.contains(tmp2)) {
                    visited.add(tmp1);
                    visited.add(tmp2);
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}
