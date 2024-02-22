import java.util.*;

public class 길찾기게임 {

    int[][] answer;
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }

        Arrays.sort(node, (o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o2.y - o1.y);

        Node root = node[0];
        for (int i = 1; i < node.length; i++) {
            insertNode(root, node[i]);
        }

        answer = new int[2][nodeinfo.length];
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);

        return answer;
    }

    public void preorder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }

    public void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    public class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
