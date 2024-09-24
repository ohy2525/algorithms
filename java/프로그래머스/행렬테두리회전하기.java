package 프로그래머스;

import java.util.*;

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] graph = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                graph[i][j] = num++;
            }
        }

        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        int[] answer = new int[queries.length];
        int answerIndex = 0;

        for (int[] query : queries) {
            int a = query[0] - 1, b = query[1] - 1, c = query[2] - 1, d = query[3] - 1;
            for (int n = 0; n < d - b; n++) {
                tmp.add(graph[a][b + n]);
            }
            for (int n = 0; n < c - a; n++) {
                tmp.add(graph[a + n][d]);
            }
            for (int n = 0; n < d - b; n++) {
                tmp.add(graph[c][d - n]);
            }
            for (int n = 0; n < c - a; n++) {
                tmp.add(graph[c - n][b]);
            }

            int last = tmp.removeLast();
            tmp.addFirst(last);
            answer[answerIndex++] = Collections.min(tmp);

            for (int n = 0; n < d - b; n++) {
                graph[a][b + n] = tmp.removeFirst();
            }
            for (int n = 0; n < c - a; n++) {
                graph[a + n][d] = tmp.removeFirst();
            }
            for (int n = 0; n < d - b; n++) {
                graph[c][d - n] = tmp.removeFirst();
            }
            for (int n = 0; n < c - a; n++) {
                graph[c - n][b] = tmp.removeFirst();
            }
        }

        return answer;
    }
}
