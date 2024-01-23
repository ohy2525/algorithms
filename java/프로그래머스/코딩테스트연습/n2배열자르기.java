package 프로그래머스.코딩테스트연습;

import java.util.*;

public class n2배열자르기 {

    public ArrayList<Integer> solution(int n, long left, long right) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            if (i / n <= i % n) {
                answer.add((int) (i % n) + 1);
            } else {
                answer.add((int) (i / n) + 1);
            }
        }

        return answer;
    }
}
