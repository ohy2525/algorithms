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
}
