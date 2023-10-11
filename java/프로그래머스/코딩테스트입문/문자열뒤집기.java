package 프로그래머스.코딩테스트입문;

public class 문자열뒤집기 {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            answer += my_string.charAt(my_string.length() - i - 1);
        }
        return answer;
    }

    public String solution2(String my_string) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        return sb.reverse().toString();
    }
}
