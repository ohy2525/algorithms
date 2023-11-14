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

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        q.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }

        return ans;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = entryList.get(i).getKey();
        }

        return ans;
    }
}
