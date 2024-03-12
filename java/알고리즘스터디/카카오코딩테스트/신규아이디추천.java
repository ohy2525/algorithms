package 알고리즘스터디.카카오코딩테스트;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        // Step1
        new_id = new_id.toLowerCase();

        // Step2
        Pattern pattern = Pattern.compile("[0-9a-zA-Z-_.]+");
        Matcher matcher = pattern.matcher(new_id);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            sb.append(matcher.group());
        }
        new_id = sb.toString();

        // Step3
        new_id = new_id.replaceAll("[.]+", ".");

        // Step4
        if (new_id.length() > 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        // Step5
        if (new_id.length() == 0) new_id = "a";

        // Step6
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        // Step7
        while (new_id.length() < 3) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
