package 알고리즘스터디.중급;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int index) {
        if (node == null) return;

        if (result.size() <= index) {
            result.add(new ArrayList<>());
        }

        result.get(index).add(node.val);

        dfs(node.left, index + 1);
        dfs(node.right, index + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
