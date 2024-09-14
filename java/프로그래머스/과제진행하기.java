package 프로그래머스;

import java.util.*;

public class 과제진행하기 {
    public static int convertTime(String s) {
        String[] timeParts = s.split(":");
        int h = Integer.parseInt(timeParts[0]);
        int m = Integer.parseInt(timeParts[1]);
        return h * 60 + m;
    }

    public static List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        List<Object[]> planList = new ArrayList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            int start = convertTime(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            planList.add(new Object[]{name, start, playtime});
        }

        planList.sort((a, b) -> (int) a[1] - (int) b[1]);

        ArrayDeque<Object[]> stack = new ArrayDeque<>();
        int leftTime = 0;

        for (int i = 0; i < planList.size(); i++) {
            String name = (String) planList.get(i)[0];
            int start = (int) planList.get(i)[1];
            int playtime = (int) planList.get(i)[2];

            while (!stack.isEmpty()) {
                Object[] lastAssign = stack.pollLast();
                String _name = (String) lastAssign[0];
                int _playtime = (int) lastAssign[1];

                if (leftTime >= _playtime) {
                    leftTime -= _playtime;
                    answer.add(_name);
                } else {
                    stack.addLast(new Object[]{_name, _playtime - leftTime});
                    break;
                }
            }

            stack.addLast(new Object[]{name, playtime});

            if (i < planList.size() - 1) {
                int nextStart = (int) planList.get(i + 1)[1];
                leftTime = nextStart - start;
            }
        }

        while (!stack.isEmpty()) {
            Object[] lastAssign = stack.pollLast();
            String _name = (String) lastAssign[0];
            answer.add(_name);
        }

        return answer;
    }
}
