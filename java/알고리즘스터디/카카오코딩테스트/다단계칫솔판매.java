package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        Map<String, Integer> profit = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            calculate(seller[i], amount[i], parent, profit);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    private void calculate(String seller, int amount, Map<String, String> parent, Map<String, Integer> profit) {
        amount *= 100;

        while (!"-".equals(seller) && amount != 0) {
            int commission = amount / 10;
            profit.put(seller, profit.getOrDefault(seller, 0) + amount - commission);

            amount = commission;
            seller = parent.get(seller);
        }
    }
}