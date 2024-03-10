package 알고리즘스터디.카카오코딩테스트;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();

        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;

            for (int i = step; i < s.length(); i += step) {
                int end = Math.min(i + step, s.length());
                if (prev.equals(s.substring(i, end))) {
                    count++;
                } else {
                    sb.append(count >= 2 ? count + prev : prev);
                    prev = s.substring(i, end);
                    count = 1;
                }
            }

            sb.append(count >= 2 ? count + prev : prev);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    public int solution2(String s) {
        int answer = s.length();

        for (int cnt = 1; cnt <= s.length() / 2; cnt++) {
            StringBuilder sb = new StringBuilder();

            String cur = "";
            int count = 1, i = 0;
            while (i < s.length()) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    if (i == s.length()) break;
                    tmp.append(s.charAt(i++));
                }

                String target = tmp.toString();
                if (cur.equals(target)) {
                    count++;
                } else {
                    sb.append(count == 1 ? "" : String.valueOf(cnt)).append(cur);
                    cur = target;
                    count = 1;
                }
            }
            sb.append(count == 1 ? "" : String.valueOf(count)).append(cur);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
