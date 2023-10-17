package 프로그래머스.코딩테스트입문;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 진료순서정하기 {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) {
                    answer[i]++;
                }
            }
            answer[i]++;
        }

        return answer;
    }
}
