package 알고리즘스터디.고급;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        visited.add(beginWord);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();

                for (int j = 0; j < cur.length(); j++) {
                    char c = arr[j];
                    for (int k = 0; k < 26; k++) {
                        arr[j] = (char)(k + 'a');
                        if (arr[j] != c) {
                            String target = new String(arr);
                            if (words.contains(target)) {
                                if (target.equals(endWord)) {
                                    return steps + 1;
                                }
                                if (visited.add(target)) {
                                    q.add(target);
                                }
                            }
                        }
                    }
                    arr[j] = c;
                }
            }
            steps++;
        }

        return 0;
    }
}
