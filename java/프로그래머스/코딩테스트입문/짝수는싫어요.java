package 프로그래머스.코딩테스트입문;

import java.util.ArrayList;
import java.util.List;

public class 짝수는싫어요 {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer.add(i);
            }
        }

        return answer;
    }
}
