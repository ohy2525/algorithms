package 프로그래머스;

public class 피보나치수 {
    public int solution(int n) {
        int[] arr = new int[100001];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        return arr[n];
    }
}
