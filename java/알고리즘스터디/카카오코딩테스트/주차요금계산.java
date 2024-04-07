package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0], defaultPrice = fees[1], unitTime = fees[2], unitPrice = fees[3];
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> parked = new HashMap<>();
        for (String r : records) {
            String[] arr = r.split(" ");
            int carNum = Integer.valueOf(arr[1]);

            if ("IN".equals(arr[2])) {
                int inTime = convert(arr[0]);

                parked.put(carNum, inTime);
            } else {
                int time = convert(arr[0]) - parked.get(carNum);
                parked.remove(carNum);

                result.put(carNum, result.getOrDefault(carNum, 0) + time);
            }
        }

        int closingTime = 23 * 60 + 59;
        for (Map.Entry<Integer, Integer> p : parked.entrySet()) {
            int time = closingTime - p.getValue();

            result.put(p.getKey(), result.getOrDefault(p.getKey(), 0) + time);
        }

        for (Map.Entry<Integer, Integer> e : result.entrySet()) {
            int fee = defaultPrice;

            fee += e.getValue() > defaultTime ? Math.ceil((e.getValue() - defaultTime) / (double)unitTime) * unitPrice : 0;
            e.setValue(fee);
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>(result);

        int[] answer = new int[tm.size()];
        int idx = 0;
        for (int fee : tm.values()) {
            answer[idx++] = fee;
        }

        return answer;
    }

    private int convert(String t) {
        String[] arr = t.split(":");

        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}
