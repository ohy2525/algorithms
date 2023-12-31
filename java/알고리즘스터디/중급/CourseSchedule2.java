package 알고리즘스터디.중급;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int idx = 0;

        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            map.putIfAbsent(pre[0], new HashSet<>());
            map.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            result[idx] = cur;
            idx++;
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }

        return idx == numCourses ? result : new int[]{};
    }
}
