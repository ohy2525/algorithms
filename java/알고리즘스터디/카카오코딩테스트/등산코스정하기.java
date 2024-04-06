package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 등산코스정하기 {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> g = new HashSet<>();
        for (int gate : gates) g.add(gate);
        Set<Integer> s = new HashSet<>();
        for (int summit : summits) s.add(summit);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1]
                        ? a[0] - b[0]
                        : a[1] - b[1]);
        Map<Integer, Set<int[]>> map = new HashMap<>();

        for (int[] p : paths) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[0]).add(new int[]{p[1], p[2]});
            map.get(p[1]).add(new int[]{p[0], p[2]});
            if (g.contains(p[0])) {
                pq.add(new int[]{p[1], p[2]});
            }
            if (g.contains(p[1])) {
                pq.add(new int[]{p[0], p[2]});
            }
        }

        Set<Integer> visited = new HashSet<>();
        int min = Integer.MIN_VALUE, gate = Integer.MAX_VALUE;
        boolean found = false;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (found && cur[1] != min) {
                break;
            }
            min = Math.max(min, cur[1]);
            visited.add(cur[0]);
            if (s.contains(cur[0])) {
                found = true;
                gate = Math.min(gate, cur[0]);
                continue;
            }

            for (int[] next : map.get(cur[0])) {
                if (!visited.contains(next[0]) && !g.contains(next[0])) {
                    pq.add(next);
                }
            }
        }

        return new int[]{gate, min};
    }
}
