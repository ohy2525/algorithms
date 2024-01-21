package 알고리즘스터디.카카오코딩테스트;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String binary1 = binary(arr1[i], n);
            String binary2 = binary(arr2[i], n);
            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '0' && binary2.charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }

    public String binary(int num, int n) {

        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            for (int i = 0; i < n; i++) {
                sb.append("0");
            }
            return sb.toString();
        }

        while (num > 0) {
            int remainder = num % 2;
            sb.insert(0, remainder);
            num = num / 2;
        }

        if (sb.length() < n) {
            int c = n - sb.length();
            for (int i = 0; i < c; i++) {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    public String[] answer(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);

            StringBuilder sb = new StringBuilder();
            for (int idx = s.length() - 1; idx >= 0; idx--) {
                sb.append((s.charAt(idx) == '1') ? "#" : " ");
            }

            while (sb.length() < n) {
                sb.append(" ");
            }

            answer[i] = sb.reverse().toString();
        }

        return answer;
    }
}
