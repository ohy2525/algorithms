package 프로그래머스.코딩테스트연습;

public class _2개이하로다른비트 {
    public static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }

        return answer;
    }
}
