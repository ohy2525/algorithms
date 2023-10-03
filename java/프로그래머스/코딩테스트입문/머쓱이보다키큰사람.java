package 프로그래머스.코딩테스트입문;

//https://school.programmers.co.kr/learn/courses/30/lessons/120585
public class 머쓱이보다키큰사람 {

    public int solution(int[] array, int height) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) {
                answer++;
            }
        }
        return answer;
    }
}
