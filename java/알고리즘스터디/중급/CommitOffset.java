package 알고리즘스터디.중급;

import java.util.Arrays;

public class CommitOffset {
    public static int[] commitOffsets(int[] offsets) {
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
