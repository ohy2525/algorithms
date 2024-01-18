package 프로그래머스.코딩테스트연습;

import java.util.*;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int idx = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                idx = i;
                break;
            }
            if (!set.add(words[i])) {
                idx = i;
                break;
            }
        }
        if (idx == 0) return new int[] {0, 0};
        if ((idx + 1) % n == 0) {
            answer[0] = n;
            answer[1] = (idx + 1) / n;
        } else {
            answer[0] = (idx + 1) % n;
            answer[1] = (idx + 1) / n + 1;
        }

        return answer;
    }
}
