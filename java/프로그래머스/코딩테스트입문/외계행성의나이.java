package 프로그래머스.코딩테스트입문;

public class 외계행성의나이 {
    public String solution(int age) {
        String answer = "";
        String s = String.valueOf(age);
        String[] arr = s.split("");
        for (String s1 : arr) {
            answer += ((char)(Integer.parseInt(s1) + 97));
        }
        return answer;
    }
}
