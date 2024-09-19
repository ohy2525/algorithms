package 프로그래머스;

import java.util.*;

public class 이모티콘할인행사 {
    static int[] discount = {10, 20, 30, 40};
    static List<int[]> caseList = new ArrayList<>();

    public int[] solution(int[][] users, int[] emotions) {
        init(new ArrayList<>(), 0, emotions.length);
        int[] answer = {0, 0};

        for (int[] c : caseList) {
            int amount = 0;
            int cnt = 0;

            for (int[] user : users) {
                int tmp = 0;
                for (int i = 0; i < emotions.length; i++) {
                    if (c[i] >= user[0]) {
                        tmp += emotions[i] * (100 - c[i]) / 100;
                    }
                }

                if (tmp >= user[1]) {
                    cnt++;
                } else {
                    amount += tmp;
                }
            }

            if (cnt >= answer[0]) {
                if (cnt == answer[0]) {
                    answer[1] = Math.max(answer[1], amount);
                } else {
                    answer[0] = cnt;
                    answer[1] = amount;
                }
            }
        }

        return answer;
    }

    private void init(ArrayList<Integer> arr, int d, int l) {
        if (d == l) {
            caseList.add(arr.stream().mapToInt(i -> i).toArray());
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr.add(discount[i]);
            init(arr, d + 1, l);
            arr.remove(arr.size() - 1);
        }
    }
}
