package Doit.ch03;

import java.util.Arrays;

public class Q06 {
    public static void main(String[] args) {
        int key = 23;
        int[] x = {15, 27, 39, 77, 92, 108, 121};
        int idx = Arrays.binarySearch(x, key);

        if (idx < 1) {
            System.out.println(-idx - 1);
        } else {
            System.out.println(idx);
        }
    }
}
