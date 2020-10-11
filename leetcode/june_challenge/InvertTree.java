package leetcode.june_challenge;

public class InvertTree {

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

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode node = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        node.left = right;
        node.right = left;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }

}