package Doit.ch03;

public class Q03 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[count++] = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int n = 8;
        int key = 9;
        int[] idx = new int[n];

        int count = searchIdx(a, n, key, idx);
        System.out.println("count = " + count);
        for (int i : idx) {
            System.out.print(i);
        }
    }
}
