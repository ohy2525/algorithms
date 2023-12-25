package 알고리즘스터디.중급;

public class CorporateFlightBookings {
    public int[] corpFlightBooking(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i < booking[1]; i++) {
                answer[i] += booking[2];
            }
        }

        return answer;
    }

    //누적합
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            int tickets = booking[2];
            int from = booking[0];
            int to = booking[1];

            ans[from - 1] += tickets;
            if (to < n) {
                ans[to] -= tickets;
            }
        }

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += ans[i];
            ans[i] = currSum;
        }

        return ans;
    }
}
