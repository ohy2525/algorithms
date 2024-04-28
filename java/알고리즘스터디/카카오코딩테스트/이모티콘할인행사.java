package 알고리즘스터디.카카오코딩테스트;

public class 이모티콘할인행사 {
    int[] result = new int[]{0, 0};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];

        find(users, emoticons, 0, discount);

        return result;
    }

    private void find(int[][] users, int[] emoticons, int idx, int[] discount) {
        if (idx == emoticons.length) {
            int plusCnt = 0, sales = 0;

            for (int[] u : users) {
                int bought = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discount[i] >= u[0]) {
                        bought += emoticons[i] * (100 - discount[i]) / 100;
                    }
                }

                if (bought >= u[1]) {
                    plusCnt++;
                } else {
                    sales += bought;
                }
            }

            if (plusCnt == result[0]) {
                result[1] = Math.max(result[1], sales);
            } else if (plusCnt > result[0]) {
                result = new int[]{plusCnt, sales};
            }

            return;
        }

        for (int i = 1; i <= 4; i++) {
            discount[idx] = i * 10;
            find(users, emoticons, idx + 1, discount);
        }
    }

}
