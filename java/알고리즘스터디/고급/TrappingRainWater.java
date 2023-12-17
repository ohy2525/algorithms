package 알고리즘스터디.고급;

public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];

        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                if (height[l] < lmax) {
                    result += lmax - height[l];
                } else {
                    lmax = height[l];
                }
            } else {
                r--;
                if (height[r] < rmax) {
                    result += rmax - height[r];
                } else {
                    rmax = height[r];
                }
            }
        }

        return result;
    }
}
