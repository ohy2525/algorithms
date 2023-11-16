package 알고리즘스터디.고급;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            e.setValue(e.getValue() - 1);
            q.add(e);
            sb.append(e.getKey());

            if (q.size() < k) {
                continue;
            }

            Map.Entry<Character, Integer> qe = q.poll();
            if (qe.getValue() > 0) {
                pq.add(qe);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
