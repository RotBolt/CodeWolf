package binray_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Client {

    // 50 true 25 true 12 false true 20 false false true 37 true 30 false false
    // false true 75 true 62 false false true 87 false false
    public static void main(final String[] args) {
        final BinaryTree tree = new BinaryTree();
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