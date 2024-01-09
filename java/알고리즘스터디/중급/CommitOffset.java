package 알고리즘스터디.중급;

import java.util.*;

public class CommitOffset {

    static int[] commitOffsets(int[] offsets) {
        int[] result = new int[offsets.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < offsets.length; i++) {
            int offset = offsets[i];
            map.put(offset, offset);
            int lowest = offset, highest = offset;

            if (map.containsKey(offset - 1)) {
                lowest = map.get(offset - 1);
            }
            if (map.containsKey(offset + 1)) {
                highest = map.get(offset + 1);
            }

            map.put(lowest, highest);
            map.put(highest, lowest);

            result[i] = lowest == 0 ? highest : -1;
        }

        return result;
    }

     static int[] commitOffsets2(int[] offsets) {
        int[] result = new int[offsets.length];
        Arrays.fill(result, -1);
        int max = offsets[0];
        for (int i = 0; i < offsets.length; i++) {
            max = Math.max(max, offsets[i]);
        }
        boolean[] check = new boolean[max + 1];

        int maxOffset = 0;
        for (int i = 0; i < offsets.length; i++) {
            check[offsets[i]] = true;
            for (int j = maxOffset; j < max + 1; j++) {
                if (check[j]) {
                    maxOffset = j;
                } else {
                    break;
                }
            }
            if (offsets[i] <= maxOffset) {
                result[i] = maxOffset;
            }
        }
        return result;
    }
}
