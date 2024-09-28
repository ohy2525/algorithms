package 프로그래머스;

import java.util.*;

public class 개인정보수집유효기간 {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] todaySplit = today.split("\\.");
        int today_ = Integer.parseInt(todaySplit[0]) * 12 * 28 + Integer.parseInt(todaySplit[1]) * 28 + Integer.parseInt(todaySplit[2]);

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termsMap.put(t[0], Integer.parseInt(t[1]));
        }
        int idx = 1;
        for (String privacy : privacies) {
            String[] tmp = privacy.split(" ");
            String p = tmp[1];
            Integer term = termsMap.get(p);
            String[] date = tmp[0].split("\\.");
            int target = term * 28 + Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
            System.out.println(today_  + "#####" + target);
            if (today_ >= target) {
                answer.add(idx);
            }
            idx++;
        }

        return answer;
    }
}
