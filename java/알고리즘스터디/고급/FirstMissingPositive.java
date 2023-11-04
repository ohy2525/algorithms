package 알고리즘스터디.고급;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean[] arr = new boolean[100001];

        for (int num : nums) {
            if (num > 0 && num < 100001 && !arr[num]) {
                arr[num] = true;
            }
        }

        for (int i = 1; i < 100001; i++) {
            if (!arr[i]) return i;
        }

        return 100001;
    }
}
