package 프로그래머스.코딩테스트입문;

//https://school.programmers.co.kr/learn/courses/30/lessons/120583?language=java
public class 중복된숫자개수 {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                answer++;
            }
        }
        return answer;
    }
}
