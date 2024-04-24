package 알고리즘스터디.카카오코딩테스트;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0, p = 0;
        for (int i = deliveries.length - 1; i >= 0; i--) {
            int cnt = 0;

            d -= deliveries[i];
            p -= pickups[i];

            while (d < 0 || p < 0) {
                d += cap;
                p += cap;
                cnt += 1;
            }
            answer += (i + 1) * 2 * cnt;
        }

        return answer;
    }
}
