package generic_tree;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node){
        System.out.print(node.data+" ");

        for(Node child : node.children){
            preOrder(child);
        }
    }

    // Node < child
    // Right side of eular path
    // While popping out in recursion
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node){
        for(Node child : node.children){
            postOrder(child);
        }
        System.out.print(node.data+" ");
    }

    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            Node rem = queue.removeFirst();
            System.out.print(rem.data + " ");
            for(Node child : rem.children){
                queue.addLast(child);
            }
        }
        System.out.println(".");
    }

    private class Pair{
        Node node;
        int level;
    }

    public void levelOrderLW(){
        Queue<Pair> queue = new LinkedList<>();
        Pair rootPair = new Pair();
        rootPair.node = root;
        rootPair.level = 0;

        queue.add(rootPair);
        Pair prev = null;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if(prev != null && prev.level != curr.level){
                System.out.println();
            }
            System.out.print(curr.node.data+" ");
            for(Node child : curr.node.children){
                Pair childPair = new Pair();
                childPair.node = child;
                childPair.level = curr.level + 1;
                queue.add(childPair);
            }

            prev = curr;
        }
    }
}