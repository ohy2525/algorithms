package 프로그래머스.코딩테스트입문;

import java.util.HashMap;

public class 모스부호1 {
    public String solution(String letter) {
        String answer = "";

        HashMap<String, String> morse = new HashMap<String, String>() {{
            put(".-", "a");
            put("-...", "b");
            put("-.-.", "c");
            put("-..", "d");
            put(".", "e");
            put("..-.", "f");
            put("--.", "g");
            put("....", "h");
            put("..", "i");
            put(".---", "j");
            put("-.-", "k");
            put(".-..", "l");
            put("--", "m");
            put("-.", "n");
            put("---", "o");
            put(".--.", "p");
            put("--.-", "q");
            put(".-.", "r");
            put("...", "s");
            put("-", "t");
            put("..-", "u");
            put("...-", "v");
            put(".--", "w");
            put("-..-", "x");
            put("-.--", "y");
            put("--..", "z");
        }};
        String[] s = letter.split(" ");
        for (String w : s) {
            answer += morse.get(w);
        }
        return answer;
    }
}
