package generic_tree;

import java.util.ArrayList;
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

    public int calculateSize(){
       return calculateSize(root);
    }

    private int calculateSize(Node node){
        int size = 1;
        for(Node child: node.children){
            size += calculateSize(child);
        }
        return size;
    }

}