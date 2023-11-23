package 알고리즘스터디.중급;

import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
		
		return pq.size();
    }
}
