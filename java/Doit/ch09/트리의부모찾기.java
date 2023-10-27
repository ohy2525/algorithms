package Doit.ch09;

import java.util.*;

import java.io.*;



public class 트리의부모찾기 {

    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            edges.get(node1).add(node2);
            edges.get(node2).add(node1);
        }
        br.close();

        visited = new int[N + 1];

        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int node) {
        for (int i : edges.get(node)) {
            if (visited[i] == 0) {
                visited[i] = node;
                dfs(i);
            }
        }
    }
}
