package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 압축 {
    public ArrayList<Integer> solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        int idx= 1;

        for (int i = 0; i < 26; i++) {
            int tmp = 65 + i;
            dic.put(String.valueOf((char) tmp), idx);
            idx++;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;

        while (i < msg.length()) {
            String tmp = "";
            while (i < msg.length()) {
                if (!dic.containsKey(tmp + msg.charAt(i))) break;
                tmp += msg.charAt(i);
                i++;
            }
            answer.add(dic.get(tmp));
            if (i < msg.length()) dic.put(tmp + msg.charAt(i), idx++);
        }

        return answer;
    }
}
