package leetcode.may_challenge.week3;

public class KthSmallestBST {
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

    private class Count {
        int value = 0;
    }

    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k, new Count()).val;
    }

    public TreeNode helper(TreeNode node, int k, Count count) {
        if (node == null) {
            return null;
        }

        TreeNode left = helper(node.left, k, count);
        if (left != null) {
            return left;
        }

        count.value++;

        if (count.value == k) {
            return node;
        }

        TreeNode right = helper(node.right, k, count);
        return right;
    }

}