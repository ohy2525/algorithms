package 알고리즘스터디.카카오코딩테스트;

public class 자동완성 {
    class Trie {
        int cnt = 0;
        Trie[] next = new Trie[26];
        boolean isWord = false;
    }

    Trie root = new Trie();
    int result = 0;

    public int solution(String[] words) {
        for (String word : words) {
            buildTrie(root, word);
        }

        find(root, 0);

        return result;
    }

    private void find(Trie node, int depth) {
        if (node.cnt == 1) {
            result += depth;
            return;
        }
        if (node.isWord) {
            result += depth;
        }

        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                find(node.next[i], depth + 1);
            }
        }
    }

    private void buildTrie(Trie node, String word) {
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
            node.cnt++;
        }

        node.isWord = true;
    }
}
