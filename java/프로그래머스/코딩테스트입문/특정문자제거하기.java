package 프로그래머스.코딩테스트입문;

public class 특정문자제거하기 {
    public String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replace(letter, "");
        return answer;
    }
}
