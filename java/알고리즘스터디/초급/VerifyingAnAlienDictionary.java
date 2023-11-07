package 알고리즘스터디.초급;

import java.util.*;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSored(String[] words, String order) {
        if (words == null || words.length == 1) return true;
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabet.put(order.charAt(i), i);
        }

        String curWord = words[0];
        for (int i = 1; i < words.length; i++) {
            String nextWord = words[i];
            boolean allSame = true;
            for (int j = 0; j < Math.min(curWord.length(), nextWord.length()); j++) {
                char c1 = curWord.charAt(j);
                char c2 = nextWord.charAt(j);

                if (c1 != c2) {
                    allSame = false;
                    if (alphabet.get(c1) > alphabet.get(c2)) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
            if (allSame && curWord.length() > nextWord.length()) return false;

            curWord = nextWord;
        }
        return true;
    }
}
