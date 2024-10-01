package 프로그래머스;

import java.util.*;

public class 배달 {
    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        int INF = (int) 1e9;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            graph.get(r[0]).add(new int[] {r[1], r[2]});
            graph.get(r[1]).add(new int[] {r[0], r[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, 1});
        distance[1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0];
            int now = current[1];

            if (distance[now] < dist) continue;

            for (int[] neighbor : graph.get(now)) {
                int cost = dist + neighbor[1];
                if (cost < distance[neighbor[0]]) {
                    distance[neighbor[0]] = cost;
                    pq.add(new int[]{cost, neighbor[0]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] <= k) {
                answer++;
            }
        }

        return answer;
    }
}
