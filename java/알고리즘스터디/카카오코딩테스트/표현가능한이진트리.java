package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            String s = Long.toBinaryString(n);
            int len = s.length(), depth = 1, cnt = 1;

            while (len > cnt) {
                depth *= 2;
                cnt += depth;
            }

            s = "0".repeat(cnt - len) + s;

            answer[i] = isValid(s.toCharArray(), s.length() / 2, 0, s.length() - 1, false) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValid(char[] arr, int idx, int l, int r, boolean shouldBeZero) {
        if (shouldBeZero && arr[idx] != '0') return false;
        if (l == r) return true;

        int leftMid = (l + idx - 1) / 2;
        int rightMid = (idx + 1 + r) / 2;
        boolean isZero = arr[idx] == '0';

        return isValid(arr, leftMid, l, idx - 1, isZero) && isValid(arr, rightMid, idx + 1, r, isZero);
    }
}
