package 프로그래머스.코딩테스트연습.스택큐;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        int currentWeight = 0;
        int index = 0;
        while (index < truck_weights.length) {
            currentWeight -= q.pollFirst();
            answer++;
            if (currentWeight + truck_weights[index] <= weight) {
                q.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                q.add(0);
            }
        }
        
        return answer + bridge_length;
    }
}
