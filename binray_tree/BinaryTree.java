package binray_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    private Node root;
    private int size;

    public BinaryTree() {
        root = construct(new Scanner(System.in), null, false);
    }

    private Node construct(Scanner scn, Node parent, boolean ilc) {

        if (parent == null) {
            System.out.println("Enter the data for root ");
        } else {
            if (ilc) {
                System.out.println("Enter data for left child of " + parent.data);
            } else {
                System.out.println("Enter data for right child of " + parent.data);
            }
        }

        int cdata = scn.nextInt();
        Node child = new Node();
        child.data = cdata;
        this.size++;
        System.out.println("Do you have left child for " + child.data);
        boolean hlc = scn.nextBoolean();

        if (hlc) {
            child.left = construct(scn, child, true);
        }

        System.out.println("Do you have right child for " + child.data);
        boolean hrc = scn.nextBoolean();

        if (hrc) {
            child.right = construct(scn, child, false);
        }

        return child;
    }

    // public BinaryTree(int[] preOrder, int[] inOrder) {
    // root = construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length
    // - 1);
    // this.size = preOrder.length;
    // }

    // private Node construct(int[] pre, int psi, int pei, int[] ino, int isi, int
    // iei) {

    // if (psi > pei || isi > iei) {
    // return null;
    // }

    // Node node = new Node();
    // node.data = pre[psi];

    // // search the element in inOrder
    // int idx = -1;
    // for (idx = isi; idx <= iei; idx++) {
    // if (pre[psi] == ino[idx]) {
    // break;
    // }
    // }

    // int nle = idx - isi;

    // node.left = construct(pre, psi + 1, psi + nle, ino, isi, idx - 1);
    // node.right = construct(pre, psi + nle + 1, pei, ino, idx + 1, iei);

    // return node;
    // }

    public BinaryTree(int[] posto, int[] ino) {
        root = construct(posto, 0, posto.length - 1, ino, 0, ino.length - 1);
        this.size = posto.length;
    }

    private Node construct(int[] posto, int psi, int pli, int[] ino, int isi, int ili) {
        if (psi > pli || isi > ili) {
            return null;
        }

        Node node = new Node();
        node.data = posto[pli];

        int i = -1;
        for (i = isi; i <= ili; i++) {
            if (posto[pli] == ino[i]) {
                break;
            }
        }

        int nre = ili - i;

        node.left = construct(posto, psi, pli - nre - 1, ino, isi, i - 1);
        node.right = construct(posto, pli - nre, pli - 1, ino, i + 1, ili);

        return node;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.left == null ? "END ->" : node.left.data + "->");
        System.out.print(node.data);
        System.out.println(node.right == null ? "<-END" : "<-" + node.right.data);
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int calcSize() {
        return calcSize(root);
    }

    private int calcSize(Node node) {
        if (node == null) {
            return 0;
        }

        int lc = calcSize(node.left);
        int rc = calcSize(node.right);

        return rc + lc + 1;
    }

    public int maxNode() {
        return maxNode(root);
    }

    private int maxNode(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lMax = maxNode(node.left);
        int rMax = maxNode(node.right);

        return Math.max(node.data, Math.max(lMax, rMax));
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        } else {
            return find(node.left, data) || find(node.right, data);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.data + " ");
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void levelOrderLW() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node rem = q.poll();

            if (rem != null) {
                System.out.print(rem.data + " ");
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            } else if (rem == null && !q.isEmpty()) {
                q.add(null);
                System.out.println();
            }
        }
        System.out.println();
    }

    private class IPair {
        Node node;
        boolean printCall;
        boolean leftCall;
        boolean rightCall;

        IPair(Node node) {
            this.node = node;
        }
    }

    public void preOrderIterative() {
        Stack<IPair> stack = new Stack<>();

        stack.push(new IPair(root));

        while (!stack.isEmpty()) {
            IPair top = stack.peek();

            if (top.node == null) {
                stack.pop();
                continue;
            }

            if (!top.printCall) {
                System.out.print(top.node.data + " ");
                top.printCall = true;
            } else if (!top.leftCall) {
                top.leftCall = true;
                stack.push(new IPair(top.node.left));
            } else if (!top.rightCall) {
                top.rightCall = true;
                stack.push(new IPair(top.node.right));
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    public void printSingleChild() {
        printSingleChild(root, root.left);
        printSingleChild(root, root.right);
        System.out.println();
    }

    private void printSingleChild(Node parent, Node child) {

        if (child == null) {
            return;
        }

        if ((parent.left == child && parent.right == null) || (parent.right == child && parent.left == null)) {
            System.out.print(child.data + " ");
        }

        printSingleChild(child, child.left);
        printSingleChild(child, child.right);
    }

    public void removeLeaves() {
        removeLeaves(root, root.left);
        removeLeaves(root, root.right);
    }

    private void removeLeaves(Node parent, Node child) {

        if (child == null) {
            return;
        }

        if (child.left == null && child.right == null) {
            if (parent.left == child) {
                parent.left = null;
            }
            if (parent.right == child) {
                parent.right = null;
            }
            return;
        }
        removeLeaves(child, child.left);
        removeLeaves(child, child.right);

    }

    public ArrayList<Integer> rootToPath(int data) {
        return rootToPath(root, data);
    }

    private ArrayList<Integer> rootToPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0, node.data);
            return path;
        }
        ArrayList<Integer> lPath = rootToPath(node.left, data);
        if (lPath.size() != 0) {
            lPath.add(0, node.data);
            return lPath;
        }
        ArrayList<Integer> rPath = rootToPath(node.right, data);
        if (rPath.size() != 0) {
            rPath.add(0, node.data);
            return rPath;
        }
        return new ArrayList<>();
    }

    public void printKFarNodes(int data, int k) {
        printKFarNodes(root, data, k);
        System.out.println();
    }

    private void printKFarNodesDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0 && node != null) {
            System.out.print(node.data + " ");
            return;
        }
        printKFarNodesDown(node.left, k - 1);
        printKFarNodesDown(node.right, k - 1);

    }

    private int printKFarNodes(Node node, int data, int k) {
        if (node == null) {
            return -1;
        }
        // print k nodes down from target
        if (node.data == data) {
            printKFarNodesDown(node, k);
            return 0;
        }
        // print ancestors
        int dl = printKFarNodes(node.left, data, k);
        // target found in left sub tree
        if (dl != -1) {
            if (dl + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                // substract 2 because 2 edges from target to right subtree
                printKFarNodesDown(node.right, k - dl - 2);
            }
            return 1 + dl;
        }
        int dr = printKFarNodes(node.right, data, k);
        // target found in right sub tree
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                // substract 2 because 2 edges from target to left subtree
                printKFarNodesDown(node.right, k - dr - 2);
            }
            return 1 + dr;
        }
        return -1;
    }

    public void printRootToPathTarget(int target) {
        printRootToPathTarget(root, 0, "", target);
    }

    private void printRootToPathTarget(Node node, int ssf, String psf, int target) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (ssf + node.data < target) {
                System.out.println(psf + " " + node.data);
                return;
            }
        }

        printRootToPathTarget(node.left, ssf + node.data, psf + " " + node.data, target);
        printRootToPathTarget(node.right, ssf + node.data, psf + " " + node.data, target);
    }

    public int diameter() {
        return diameter(root);
    }

    private int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        // distance between farthest node in left subtree
        int ld = diameter(node.left);

        // distance between farthest node in right subtree
        int rd = diameter(node.right);

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh + rh + 2, Math.max(ld, rd));
    }

    private class DiaPair {
        int height;
        int diameter;

        DiaPair(int height, int dia) {
            this.height = height;
            this.diameter = dia;
        }
    }

    public int diameterEff() {
        return diameterEff(root).diameter;
    }

    private DiaPair diameterEff(Node node) {
        if (node == null) {
            return new DiaPair(-1, 0);
        }

        DiaPair lp = diameterEff(node.left);
        DiaPair rp = diameterEff(node.right);

        DiaPair mp = new DiaPair(Math.max(lp.height, rp.height) + 1,
                Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter)));

        return mp;

    }

    private class BalPair {
        int height;
        boolean ib;

        BalPair(int height, boolean ib) {
            this.height = height;
            this.ib = ib;
        }
    }

    public boolean isBalanced() {
        return isBalanced(root).ib;
    }

    private BalPair isBalanced(Node node) {
        if (node == null) {
            return new BalPair(-1, true);
        }

        BalPair lp = isBalanced(node.left);
        BalPair rp = isBalanced(node.right);

        BalPair mp = new BalPair(Math.max(lp.height, rp.height) + 1,
                lp.ib && rp.ib && Math.abs(lp.height - rp.height) <= 1);

        return mp;
    }

    private class BSTPair {
        boolean isBST;
        int min;
        int max;
        Node lBSTRoot = null;
        int lBSTSize = 0;
    }

    public boolean isBST() {
        return isBST(root).isBST;
    }

    private BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

        return mp;
    }

    public void largestBST() {
        BSTPair bPair = largetsBST(root);
        System.out.println("Largest BST Size : " + bPair.lBSTSize);
        display(bPair.lBSTRoot);

    }

    private BSTPair largetsBST(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            return bp;
        }

        BSTPair lp = largetsBST(node.left);
        BSTPair rp = largetsBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

        if (mp.isBST) {
            mp.lBSTRoot = node;
            mp.lBSTSize = lp.lBSTSize + rp.lBSTSize + 1;
        } else {
            if (lp.lBSTSize > rp.lBSTSize) {
                mp.lBSTRoot = lp.lBSTRoot;
                mp.lBSTSize = lp.lBSTSize;
            } else {
                mp.lBSTRoot = rp.lBSTRoot;
                mp.lBSTSize = rp.lBSTSize;
            }
        }

        return mp;
    }
}
