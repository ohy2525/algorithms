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
}
