package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new StrCompare());
        return files;
    }

    public class StrCompare implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int n1 = 0, n2 = 0;
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            while (n1 < s1.length() && !Character.isDigit(s1.charAt(n1))) n1++;
            while (n2 < s2.length() && !Character.isDigit(s2.charAt(n2))) n2++;

            int diff = s1.substring(0, n1).compareTo(s2.substring(0, n2));
            if (diff != 0) return diff;

            int t1 = n1, t2 = n2;
            while (t1 < s1.length() && Character.isDigit(s1.charAt(t1)) && t1 < n1 + 5) t1++;
            while (t2 < s2.length() && Character.isDigit(s2.charAt(t2)) && t2 < n2 + 5) t2++;
            int num1 = Integer.parseInt(s1.substring(n1, t1));
            int num2 = Integer.parseInt(s2.substring(n2, t2));

            return num1 - num2;
        }
    }
}
