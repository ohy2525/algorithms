package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        for (int num : queue1) {
            q1.addLast(num);
        }
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        for (int num : queue2) {
            q2.addLast(num);
        }

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        if ((sum1 + sum2) % 2 != 0) return -1;

        int answer = 0;

        while (true) {
            if (answer == queue1.length * 3) return -1;

            if (sum1 == sum2) {
                return answer;
            } else if (sum1 > sum2) {
                int tmp = q1.pollFirst();
                q2.addLast(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else {
                int tmp = q2.pollFirst();
                q1.addLast(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }

            answer++;
        }
    }
}
