package 알고리즘스터디.기출;

import java.util.Arrays;

public class auto_ever_2024_1 {
    public static void main(String[] args) {
        System.out.println(find(6, 5, 2, new int[]{3, 7, 10, 13, 17, 20}, new int[][]{{1, 10}, {3, 9}, {4, 23}, {12, 19}, {3, 15}}));
    }

    static class Device {
        int num;
        int usage;

        Device(int n, int u) {
            this.num = n;
            this.usage = u;
        }
    }

    private static int find(int n, int q, int k, int[] devices, int[][] lane) {
        int[] usage = new int[n + 1];

        for (int[] l : lane) {
            int s = findIdx(l[0], devices);
            int e = findIdx(l[1], devices);
            if (l[1] < devices[e]) e--;

            usage[s]++;
            usage[e + 1]--;
        }

        Device[] arr = new Device[n];
        arr[0] = new Device(devices[0], usage[0]);
        for (int i = 1; i < usage.length - 1; i++) {
            usage[i] += usage[i - 1];
            arr[i] = new Device(devices[i], usage[i]);
        }

        Arrays.sort(arr, (a, b) -> a.usage == b.usage ? a.num - b.num : b.usage - a.usage);

        return arr[k].num;
    }

    private static int findIdx(int t, int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
           int m = l + (r - l) / 2;
           if (arr[m] == t) return m;
            if (arr[m] > t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

}
