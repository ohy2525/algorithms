package 알고리즘스터디.고급;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        List<String> tmp = new ArrayList<>();
        int curSize = 0, wordSize = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            curSize += (curSize == 0 ? 0 : 1) + word.length();
            if (curSize > maxWidth) {
                result.add(flush(tmp, maxWidth, wordSize, false));
                i--;
                tmp = new ArrayList<>();
                curSize = 0;
                wordSize = 0;
            } else {
                tmp.add(word);
                wordSize += word.length();
            }
        }
        result.add(flush(tmp, maxWidth, wordSize, true));

        return result;
    }

    private String flush(List<String> list, int maxWidth, int wordSize, boolean isLast) {
        int n = list.size();
        StringBuilder sb = new StringBuilder(list.get(0));

        if (n > 1) {
            int blankCnt = isLast ? 1 : (maxWidth - wordSize) / (n - 1);
            int remainingCnt = isLast ? 0 : (maxWidth - wordSize) % (n - 1);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < blankCnt; j++) {
                    sb.append(" ");
                }
                if (remainingCnt > 0) {
                    remainingCnt--;
                    sb.append(" ");
                }
            }
        }

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
