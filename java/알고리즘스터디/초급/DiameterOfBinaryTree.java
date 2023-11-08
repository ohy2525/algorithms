package 알고리즘스터디.초급;

public class DiameterOfBinaryTree {
    int depth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return depth;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        depth = Math.max(depth, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public class TreeNode {

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
}
