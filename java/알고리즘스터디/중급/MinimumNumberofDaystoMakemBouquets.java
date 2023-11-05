package 알고리즘스터디.중급;

import java.util.*;

public class MinimumNumberofDaystoMakemBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while (left < right) {
            //int mid = (left + right) / 2; //Integer 에서 오버플로우 발생 가능성 있음
            int mid = left + (right - left) / 2;
            if (getCount(bloomDay, k, mid) >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getCount(int[] bloomDay, int k, int day) {
        int bouquetCount = 0;
        int requiredBouquet = k;
        for (int n : bloomDay) {
            if (n > day) {
                requiredBouquet = k;
            } else if (--requiredBouquet == 0) {
                bouquetCount++;
                requiredBouquet = k;
            }
        }

        return bouquetCount;
    }
}
