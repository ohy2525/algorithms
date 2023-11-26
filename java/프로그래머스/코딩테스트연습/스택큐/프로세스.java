package 프로그래머스.코딩테스트연습.스택큐;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i: priorities) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (q.peek() == priorities[i]) {
                    q.poll();
                    answer++;

                    if (i == location) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
