package 알고리즘스터디.중급;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .limit(k)
                .mapToInt(entry -> Integer.parseInt(String.valueOf(entry.getKey())))
                .toArray();

        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
