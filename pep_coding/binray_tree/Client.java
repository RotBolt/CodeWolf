package pep_coding.binray_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Client {

    // 50 true 25 true 12 false true 20 false false true 37 true 30 false false
    // false true 75 true 62 false false true 87 false false
    public static void main(final String[] args) {
        // final BinaryTree tree = new BinaryTree();

        int[] pre = { 50, 25, 12, 20, 37, 30, 75, 62, 87 };
        int[] ino = { 12, 20, 21, 22, 25, 30, 31, 32, 37, 50, 62, 75, 87 };
        int[] posto = { 22, 21, 20, 12, 32, 31, 30, 37, 25, 62, 87, 75, 50 };

        // BinaryTree tree = new BinaryTree(pre, ino);

        BinaryTree tree = new BinaryTree(posto, ino);

        System.out.println(tree.getSize());

        tree.display();

        System.out.println(tree.calcSize());

        System.out.println(tree.maxNode());

        System.out.println(tree.height());

        System.out.println(tree.find(43));

        tree.preOrder();

        tree.postOrder();

        tree.inOrder();

        tree.levelOrderLW();

        // printBinaries(15);

        tree.preOrderIterative();

        tree.printSingleChild();

        // tree.display();

        // tree.removeLeaves();

        // tree.display();

        System.out.println(tree.rootToPath(30));

        tree.printKFarNodes(25, 3);

        tree.printRootToPathTarget(160);

        System.out.println("Diameter " + tree.diameter());
        System.out.println("Diameter eff " + tree.diameterEff());

        // ans = false , remove 60 to make it balanced
        int[] post = { 40, 20, 60, 50, 30, 10 };
        int[] in = { 40, 20, 10, 30, 50, 60 };

        BinaryTree tree2 = new BinaryTree(post, in);

        System.out.println("is Balanced " + tree2.isBalanced());

        // ans = false , remove 51 to make is BST
        int[] post2 = { 12, 51, 37, 25, 62, 87, 75, 50 };
        int[] in2 = { 12, 25, 37, 51, 50, 62, 75, 87 };

        BinaryTree tree3 = new BinaryTree(post2, in2);
        System.out.println(tree3.isBST());

        tree3.largestBST();
    }

    private static class Pair {
        int n;
        String bin = "";

        Pair(final int n, final String bin) {
            this.n = n;
            this.bin = bin;
        }
    }

    private static void printBinaries(final int num) {
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(1, "1"));
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            System.out.println(rem.n + "->" + rem.bin);

            if (2 * rem.n <= num) {
                q.add(new Pair(2 * rem.n, rem.bin + "0"));
            }
            if (2 * rem.n + 1 <= num) {
                q.add(new Pair(2 * rem.n + 1, rem.bin + "1"));
            }
        }

    }

}