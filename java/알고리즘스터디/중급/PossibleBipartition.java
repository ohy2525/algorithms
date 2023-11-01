package 알고리즘스터디.중급;

import java.util.*;

//https://leetcode.com/problems/possible-bipartition/description/
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0] - 1;
            int b = dislike[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                boolean result = dfs(i, graph, visited, color);
                if (!result) return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, List<List<Integer>> graph, boolean[] visited, boolean[] color) {
        for (int num : graph.get(cur)) {
            if (!visited[num]) {
                visited[num] = true;
                color[num] = !color[cur];
                boolean res = dfs(num, graph, visited, color);
                if (!res) return false;
            } else if (color[num] == color[cur]) {
                return false;
            }
        }
        return true;
    }
}
