package 프로그래머스;

public class 기사단원의무기 {
    public static int divisor(int num) {
        int count = 0;
        if (num == 1) {
            count = 1;
        } else if (num == 2) {
            count = 2;
        } else {
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (i * i == num) {
                    count += 1;
                } else if (num % i == 0) {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number];

        for (int i = 1; i <= number; i++) {
            arr[i - 1] = divisor(i);
        }

        for (int i : arr) {
            if (i > limit) {
                answer += power;
            } else {
                answer += i;
            }
        }

        return answer;
    }
}
