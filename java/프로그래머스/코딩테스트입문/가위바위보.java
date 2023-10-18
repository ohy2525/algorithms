package 프로그래머스.코딩테스트입문;

import java.util.HashMap;

public class 가위바위보 {
    public String solution(String rsp) {
        String answer = "";
        HashMap<String, String> rspMap = new HashMap<>();
        rspMap.put("0", "5");
        rspMap.put("2", "0");
        rspMap.put("5", "2");

        String[] strings = rsp.split("");
        for (String s : strings) {
            answer += rspMap.get(s);
        }

        return answer;
    }
}
