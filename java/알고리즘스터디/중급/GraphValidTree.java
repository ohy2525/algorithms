package 알고리즘스터디.중급;

import java.util.*;

//https://protegejj.gitbook.io/algorithm-practice/leetcode/graph/261-graph-valid-tree

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int curNode = queue.remove();

            // found loop
            if (visited[curNode]) {
                return false;
            }

            visited[curNode] = true;

            for (int nextNode : adjList.get(curNode)) {
                queue.add(nextNode);
                adjList.get(nextNode).remove(curNode);
            }
        }

        for (boolean e : visited) {
            if (!e) {
                return false;
            }
        }
        return true;
    }
}
