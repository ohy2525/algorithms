package 알고리즘스터디.카카오코딩테스트;

import java.util.*;

public class 가사검색 {
    class Trie {
        Trie[] next = new Trie[26];
        int children = 0;
    }

    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> map = new HashMap<>();
        Map<Integer, Trie> revMap = new HashMap<>();

        for (String word : words) {
            map.putIfAbsent(word.length(), new Trie());
            revMap.putIfAbsent(word.length(), new Trie());
            buildTree(word, map.get(word.length()));
            buildTree(new StringBuilder(word).reverse().toString(), revMap.get(word.length()));
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int cnt = 0;
            if (map.containsKey(query.length())) {
                if (query.charAt(0) == '?') {
                    cnt = count(new StringBuilder(query).reverse().toString(), revMap.get(query.length()), 0);
                } else {
                    cnt = count(query, map.get(query.length()), 0);
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    private int count(String s, Trie node, int idx) {
        char c = s.charAt(idx);

        if (c == '?') {
            return node.children;
        }

        if (node.next[c - 'a'] == null) {
            return 0;
        }

        return count(s, node.next[c - 'a'], idx + 1);
    }

    private void buildTree(String word, Trie node) {
        node.children++;

        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
            node.children++;
        }
    }
}
