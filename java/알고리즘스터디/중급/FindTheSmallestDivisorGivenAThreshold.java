package 알고리즘스터디.중급;

import java.util.*;

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (satisfy(mid, nums, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean satisfy(int divisor, int[] nums, int threshold) {
        int sum = 0;

        for (int num : nums) {
            int res = num / divisor + (num % divisor > 0 ? 1 : 0);
            sum += res;
            if (sum > threshold) return false;
        }

        return true;
    }
}
