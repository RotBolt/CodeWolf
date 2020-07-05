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
}
