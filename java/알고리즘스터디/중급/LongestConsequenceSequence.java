package 알고리즘스터디.중급;

import java.util.*;

public class LongestConsequenceSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int sum = left + right + 1;
                result = Math.max(result, sum);
                
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }

        return result;
    }
}
