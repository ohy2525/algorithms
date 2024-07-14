package 알고리즘스터디.중급;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        pathSum(root, 0, targetSum, result, new ArrayList<>());

        return result;
    }

    private void pathSum(TreeNode node, int sum, int targetSum, List<List<Integer>> result, List<Integer> tmp) {
        if (node == null) return;

        sum += node.val;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(tmp));
            }
        }

        pathSum(node.left, sum, targetSum, result, tmp);
        pathSum(node.right, sum, targetSum, result, tmp);

        tmp.remove(tmp.size() - 1);
    }
}
