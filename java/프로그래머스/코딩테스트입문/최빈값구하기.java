package 프로그래머스.코딩테스트입문;

import java.util.*;

public class 최빈값구하기 {
    public int solution(int[] array) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int answer = -1;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                answer = num;
                maxCount = count;
            } else if (count == maxCount) {
                answer = -1;
            }
        }

        return answer;
    }
}
