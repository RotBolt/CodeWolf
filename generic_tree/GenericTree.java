package generic_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
    }

    private int size;
    private Node root;

    public GenericTree() {
        this.root = construct(new Scanner(System.in), null, 0);
    }

    private Node construct(Scanner scn, Node parent, int i) {

        if (parent == null) {
            System.out.println("Enter data for root :");
        } else {
            System.out.println("Enter data for " + i + "th child of " + parent.data);
        }

        int data = scn.nextInt();

        Node child = new Node();
        child.data = data;
        this.size++;
        System.out.println("Enter number of children for " + child.data);
        int numgc = scn.nextInt();

        for (int j = 0; j < numgc; j++) {
            Node gc = construct(scn, child, j);
            child.children.add(gc);
        }

        return child;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void display() {
        display(this.root);
    }

    // Euler Path
    private void display(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.data + " -> ");
        for (Node child : node.children) {
            sb.append(child.data + ", ");
        }
        sb.append("END");
        System.out.println(sb.toString());
        for (Node child : node.children) {
            display(child);
        }
    }

    public int calculateSize() {
        return calculateSize(root);
    }

    private int calculateSize(Node node) {
        int size = 1;
        for (Node child : node.children) {
            size += calculateSize(child);
        }
        return size;
    }

    public int getMaxNodeData() {
        return getMaxNodeData(root);
    }

    private int getMaxNodeData(Node node) {
        int max = node.data;

        for (Node child : node.children) {
            int res = getMaxNodeData(child);
            if (res > max) {
                max = res;
            }
        }
        return max;
    }

    public boolean isElementExists(int element) {
        return isElementExists(element, root);
    }

    private boolean isElementExists(int element, Node node) {
        if (node.data == element) {
            return true;
        }

        for (Node child : node.children) {
            boolean cRes = isElementExists(element, child);
            if (cRes) {
                return cRes;
            }
        }
        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        int cMaxHt = -1;
        for (Node child : node.children) {
            int cHt = height(child);
            cMaxHt = Math.max(cMaxHt, cHt);
        }
        return cMaxHt + 1;
    }

    // Node > child
    // Left side of eular path
    // While going deeper in recursion
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        System.out.print(node.data + " ");

        for (Node child : node.children) {
            preOrder(child);
        }
    }

    // Node < child
    // Right side of eular path
    // While popping out in recursion
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        for (Node child : node.children) {
            postOrder(child);
        }
        System.out.print(node.data + " ");
    }

    public void levelOrder() {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node rem = queue.removeFirst();
            System.out.print(rem.data + " ");
            for (Node child : rem.children) {
                queue.addLast(child);
            }
        }
        System.out.println(".");
    }

    private class Pair {
        Node node;
        int level;
    }

    public void levelOrderLW() {
        Queue<Pair> queue = new LinkedList<>();
        Pair rootPair = new Pair();
        rootPair.node = root;
        rootPair.level = 0;

        queue.add(rootPair);
        Pair prev = null;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (prev != null && prev.level != curr.level) {
                System.out.println();
            }
            System.out.print(curr.node.data + " ");
            for (Node child : curr.node.children) {
                Pair childPair = new Pair();
                childPair.node = child;
                childPair.level = curr.level + 1;
                queue.add(childPair);
            }

            prev = curr;
        }
        System.out.println();
    }

    public void levelOrderLW2() {
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        q.add(null);

        while (!q.isEmpty()) {

            Node node = q.poll();
            if (node == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    q.add(child);
                }
            }
        }
    }

    public void levelOrderZigZag() {
        ArrayList<Node> list = new ArrayList<>();
        list.add(this.root);
        list.add(null);
        int nlIdx = 2;
        boolean ulta = false;
        while (!list.isEmpty()) {
            Node rem = list.remove(0);
            nlIdx--;
            if (rem != null) {
                System.out.print(rem.data + " ");
                List<Node> childList = rem.children;
                if (ulta) {
                    for (int i = childList.size() - 1; i >= 0; i--) {
                        Node child = childList.get(i);
                        list.add(nlIdx, child);
                    }
                } else {
                    for (Node child : childList) {
                        list.add(nlIdx, child);
                    }
                }
            } else {
                System.out.println();
                if (!list.isEmpty()) {
                    list.add(null);
                    nlIdx = list.size();
                    ulta = !ulta;
                }
            }
        }
    }

    public void levelOrderZigZagPepVersion() {
        LinkedList<Node> clq = new LinkedList<>();
        LinkedList<Node> nls = new LinkedList<>();
        boolean l2r = true;
        clq.add(root);
        while (!clq.isEmpty()) {
            Node rem = clq.poll();
            System.out.print(rem.data + " ");

            if (l2r) {
                for (int i = 0; i < rem.children.size(); i++) {
                    nls.push(rem.children.get(i));
                }
            } else {
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    nls.push(rem.children.get(i));
                }
            }

            if (clq.isEmpty()) {
                clq = nls;
                nls = new LinkedList<>();
                l2r = !l2r;
                System.out.println();
            }
        }
    }

    public void printMirrorImage() {
        mirrorImage(root);
        display();
    }

    private void mirrorImage(Node node) {
        ArrayList<Node> children = node.children;

        for (int i = 0, j = children.size() - 1; i < children.size() / 2; i++, j--) {
            Node right = children.remove(j);
            Node left = children.remove(i);
            children.add(i, right);
            children.add(j, left);
        }

        for (Node child : node.children) {
            mirrorImage(child);
        }
    }

    public void removeLeaves() {
        removeLeaves(root);
    }

    private void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.isEmpty()) {
                node.children.remove(child);
            } else {
                removeLeaves(child);
            }
        }
    }

    public void linearize() {
        linearize(root);
    }

    private void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node sl = node.children.get(node.children.size() - 2);
            Node l = node.children.remove(node.children.size() - 1);

            Node slTail = getTail(sl);
            slTail.children.add(l);
        }
    }

    private Node getTail(Node node) {
        Node tail = node;
        while (tail.children.size() == 1) {
            tail = tail.children.get(0);
        }
        return tail;
    }

    public void linearizeEffective() {
        linearizeEffective(root);
    }

    private Node linearizeEffective(Node node) {
        if (node.children.size() == 0) {
            return node;
        }
        Node olTail = linearizeEffective(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node sl = node.children.get(node.children.size() - 2);
            Node l = node.children.get(node.children.size() - 1);

            Node slKiTail = linearizeEffective(sl);
            node.children.remove(l);
            slKiTail.children.add(l);
        }

        return olTail;
    }

    public boolean isIspmorphicWith(GenericTree tree) {
        return isIsomorphic(this.root, tree.root);
    }

    private boolean isIsomorphic(Node tNode, Node oNode) {
        if (tNode.children.size() == oNode.children.size()) {
            for (int i = 0; i < tNode.children.size(); i++) {
                Node tChild = tNode.children.get(i);
                Node oChild = oNode.children.get(i);

                boolean isCIsomorphic = isIsomorphic(tChild, oChild);
                if (!isCIsomorphic) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isMirrorOf(GenericTree tree) {
        return isMirrorWith(this.root, tree.root);
    }

    private boolean isMirrorWith(Node tNode, Node oNode) {
        if (tNode.children.size() != oNode.children.size()) {
            return false;
        }

        int left = 0;
        int right = tNode.children.size() - 1;

        while (left < tNode.children.size()) {

            Node tChild = tNode.children.get(left);
            Node oChild = oNode.children.get(right);

            boolean isChildMirror = isMirrorWith(tChild, oChild);

            if (!isChildMirror) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean isSymmetric() {
        return isSymmetric(this.root);
    }

    private boolean isSymmetric(Node node) {
        if (node.children.size() == 1) {
            return true;
        }

        int left = 0;
        int right = node.children.size() - 1;
        Node lChild = node.children.get(left);
        Node rChild = node.children.get(right);

        if (lChild.children.size() == rChild.children.size()) {
            left++;
            right--;
            while (left < right) {
                lChild = node.children.get(left);
                rChild = node.children.get(right);

                boolean isLChildSymmetric = isSymmetric(lChild);
                boolean isRChildSymmetric = isSymmetric(rChild);

                if (!isLChildSymmetric || !isRChildSymmetric) {
                    return false;
                }

                left++;
                right--;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isSymmetricPep() {
        return isMirrorWith(this.root, this.root);
    }

    private class HeapMover {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;
        int height = 0;
        boolean find = false;

        Node prev = null;
        Node curr = null;

        Node pred = null;
        Node succ = null;

        int justLarger = Integer.MAX_VALUE;
    }

    public void multiSolver(int data) {
        HeapMover mover = new HeapMover();
        multiSolver(root, mover, data, 0);

        System.out.println("Size = " + mover.size);
        System.out.println("Min = " + mover.min);
        System.out.println("Max = " + mover.max);
        System.out.println("Height = " + mover.height);
        System.out.println("Found = " + mover.find);
    }

    private void multiSolver(Node node, HeapMover mover, int data, int depth) {
        mover.size++;
        mover.min = Math.min(node.data, mover.min);
        mover.max = Math.max(node.data, mover.max);
        mover.height = Math.max(depth, mover.height);
        mover.find = mover.find || node.data == data;

        for (Node child : node.children) {
            multiSolver(child, mover, data, depth + 1);
        }
    }

    public void predSucc(int data) {
        HeapMover mover = new HeapMover();
        predSucc(root, mover, data);
        System.out.println("Pred = " + (mover.prev == null ? "null" : mover.pred.data));
        System.out.println("Succ = " + (mover.succ == null ? "null" : mover.succ.data));
    }

    private void predSucc(Node node, HeapMover mover, int data) {
        mover.curr = node;

        if (mover.curr.data == data) {
            mover.pred = mover.prev;
        } else if (mover.prev != null && mover.prev.data == data) {
            mover.succ = mover.curr;
        }

        mover.prev = mover.curr;

        for (Node child : node.children) {
            predSucc(child, mover, data);
        }
    }

    public void justLarger(int data) {
        HeapMover mover = new HeapMover();
        justLarger(root, mover, data);
        System.out.println("Just Larger = " + (mover.justLarger == Integer.MAX_VALUE ? "null" : mover.justLarger));
    }

    private void justLarger(Node node, HeapMover mover, int data) {
        if (node.data > data) {
            mover.justLarger = Math.min(node.data, mover.justLarger);
        }

        for (Node child : node.children) {
            justLarger(child, mover, data);
        }
    }

    // Complexity o(n*k)
    public int kthSmallest(int k) {
        HeapMover mover = new HeapMover();
        int data = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            justLarger(root, mover, data);
            data = mover.justLarger;
            mover.justLarger = Integer.MAX_VALUE;
        }
        return data;
    }
}