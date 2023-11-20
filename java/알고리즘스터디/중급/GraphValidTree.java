package 알고리즘스터디.중급;

import java.util.*;

//https://protegejj.gitbook.io/algorithm-practice/leetcode/graph/261-graph-valid-tree

public class GraphValidTree {
    int used = 0;
    int cnt = 0;

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] e : edges) {
            int fp = findParent(parent, e[0]);
            int tp = findParent(parent, e[1]);
            if (fp == tp) return false;
            parent[fp] = tp;
            cnt--;
        }

        return used == n && cnt == 1;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] == -1) {
            parent[node] = node;
            used++; cnt++;
            return node;
        }
        if (parent[node] == node) return node;

        int p = findParent(parent, parent[node]);
        parent[node] = p;

        return p;
    }
    /*public boolean validTree(int n, int[][] edges) {
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
    }*/
}
