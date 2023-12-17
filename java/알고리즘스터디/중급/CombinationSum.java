package 알고리즘스터디.중급;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] candidates, int index, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList(list));
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
