package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        for (String log : record) {
            String[] s = log.split(" ");
            if (s.length == 3) map.put(s[1], s[2]);
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String log : record) {
            String[] s = log.split(" ");
            if (s[0].equals("Enter")) {
                answer.add(map.get(s[1]) + "님이 들어왔습니다.");
            } else if (s[0].equals("Leave")) {
                answer.add(map.get(s[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
