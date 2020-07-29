package leetcode.may_challenge.week1;

public class Cousins {

    // Definition for a binary tree node.
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

    public class CousinPair {
        int height = -1;
        TreeNode parentData;
    }

    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            CousinPair xData = dfs(root, x, null);
            CousinPair yData = dfs(root, y, null);

            return (xData.height == yData.height && xData.parentData != yData.parentData);
        }

        public CousinPair dfs(TreeNode node, int data, TreeNode parent) {
            if (node == null) {
                return null;
            }

            if (node.val == data) {
                CousinPair pair = new CousinPair();
                pair.height++;
                pair.parentData = parent;
                return pair;
            }

            CousinPair pair = dfs(node.left, data, node);
            if (pair == null) {
                pair = dfs(node.right, data, node);
            }

            if (pair != null) {
                pair.height++;
            }
            return pair;

        }
    }

}