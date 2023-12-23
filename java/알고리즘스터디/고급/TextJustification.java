package 알고리즘스터디.고급;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int width = 0;
        List<String> wordList = new ArrayList<>();
        while (i < words.length) {
            width += words[i].length();
            if (width <= maxWidth) {
                width += 1;
                wordList.add(words[i]);
                i += 1;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int tmp = 0;
            for (String s : wordList) {
                tmp += s.length();
            }
            int quot = (maxWidth - tmp) / (wordList.size() - 1);
            int rem = (maxWidth - tmp) / (wordList.size() - 1);


            width = 0;
            wordList = new ArrayList<>();

        }



        return ans;
    }
}
