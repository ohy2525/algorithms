package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (String i : info) {
            String[] arr = i.split(" ");
            int score = Integer.valueOf(arr[4]);
            add(map, arr, score, 0, "");
        }

        for (List<Integer> v : map.values()) {
            Collections.sort(v);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] arr = query[i].split(" and | ");
            int score = Integer.valueOf(arr[4]);
            String key = arr[0] + arr[1] + arr[2] + arr[3];

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            List<Integer> target = map.get(key);
            int l = 0, r = target.size() - 1;

            while (l <= r) {
                int m = l + (r - 1) / 2;
                if (target.get(m) < score) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            answer[i] = target.size() - l;
        }

        return answer;
    }

    private void add(Map<String, List<Integer>> map, String[] arr, int score, int idx, String key) {
        if (idx == 4) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }

        add(map, arr, score, idx + 1, key + arr[idx]);
        add(map, arr, score, idx + 1, key + "-");
    }
}
