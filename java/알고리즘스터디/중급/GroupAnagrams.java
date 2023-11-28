package 알고리즘스터디.중급;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 && strs == null) return new ArrayList<>();

        Map<String, List<String>> answer = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = Arrays.toString(arr);

            answer.putIfAbsent(sortedStr, new ArrayList<>());

            List<String> list = answer.get(sortedStr);
            list.add(str);
        }

        return new ArrayList<>(answer.values());
    }
}
