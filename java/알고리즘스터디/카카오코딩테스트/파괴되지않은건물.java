package 알고리즘스터디.카카오코딩테스트;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            int weight = s[5];
            if (s[0] == 1) weight *= -1;

            int sy = s[1], sx = s[2], ey = s[3], ex = s[4];
            map[sy][sx] += weight;
            map[ey + 1][sx] += -weight;
            map[sy][ex + 1] += -weight;
            map[ey + 1][ex + 1] += weight;
        }

        for (int i = 0; i < map.length; i++) {
            int weight = 0;
            for (int j = 0; j < map[i].length; j++) {
                weight += map[i][j];
                map[i][j] = weight;
            }
        }
        for (int j = 0; j < map[0].length; j++) {
            int weight = 0;
            for (int i = 0; i < map.length; i++) {
                weight += map[i][j];
                map[i][j] = weight;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + map[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
