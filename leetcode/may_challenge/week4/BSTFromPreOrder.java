package leetcode.may_challenge.week4;

import java.util.Arrays;

public class BSTFromPreOrder {

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

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    private TreeNode construct(int[] pre, int psi, int pei, int[] ino, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }

        TreeNode node = new TreeNode(pre[psi]);

        int idx = -1;

        for (idx = isi; idx <= iei; idx++) {
            if (pre[psi] == ino[idx]) {
                break;
            }
        }

        int divIdxGap = idx - isi;

        node.left = construct(pre, psi + 1, psi + divIdxGap, ino, isi, idx);
        node.right = construct(pre, psi + divIdxGap + 1, pei, ino, idx + 1, iei);

        return node;
    }

}