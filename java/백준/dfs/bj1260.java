package 백준.dfs;

import java.util.*;
import java.io.*;

public class bj1260 {
    static int n, m, k;
    static ArrayList<Integer> arr[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        br.close();

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(k);
        visited = new boolean[n + 1];
        sb.append("\n");
        bfs(k);
        System.out.println(sb);
    }

    private static void bfs(int index) {
        visited[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + " ");
            for (int i : arr[num]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int index) {
        visited[index] = true;
        sb.append(index + " ");
        for (int i : arr[index]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
