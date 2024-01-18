package 프로그래머스.코딩테스트연습;

public class 이진변환반복하기 {
    static int cnt = 0;
    static int cnt0 = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            s = remove0(s);
            s = makeBinary(s);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = cnt0;

        return answer;
    }

    public String makeBinary(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        while (len > 0) {
            int remainder = len % 2;
            sb.insert(0, remainder);
            len /= 2;
        }

        return sb.toString();
    }

    public String remove0(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                sb.append('1');
            } else {
                cnt0++;
            }
        }

        return sb.toString();
    }
}
