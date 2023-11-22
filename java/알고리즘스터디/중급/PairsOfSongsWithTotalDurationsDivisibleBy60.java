package 알고리즘스터디.중급;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        long[] arr = new long[60];
        long answer = 0;

        for (int t : time) {
            arr[t % 60] += 1;
        }

        for (int i = 1; i < 30; i++) {
            answer += arr[i] * arr[60 - i];
        }

        if (arr[0] != 0) {
            answer += arr[0] * (arr[0] - 1) / 2;
        }

        if (arr[30] != 0) {
            answer += arr[30] * (arr[30] - 1) / 2;
        }

        return (int) answer;
    }
}
