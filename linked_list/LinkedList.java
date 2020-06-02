package linked_list;

public class LinkedList {

    private class Node {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(int data) {
        if (isEmpty()) {
            handleFirstAddition(data);
            return;
        }
        Node node = new Node();
        node.data = data;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void addFirst(int data){
        if(isEmpty()){
            handleFirstAddition(data);
            return;
        }
        Node node = new Node();
        node.data = data;
        node.next = this.head;

        this.head = node;

        this.size++;

    }

    public void addAt(int index, int data) throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        if(index > size || index < 0){
            throw new Exception("Index out of Bounds");
        }
        if(index == 0){
            addFirst(data);
        }
        if(index == size){
            addLast(data);
        }

        Node item = getNodeAt(index-1);
        Node node = new Node();
        node.data = data;
        
        node.next = item.next;
        item.next = node;
        size ++;

    }

    public int getFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        return this.head.data;
    }

    public int getLast() throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        return this.tail.data;
    }

    public int getAt(int index) throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        if(index == size || index < 0){
            throw new Exception("Index out of Bounds");
        }

        if(index == 0){
            return getFirst();
        }
        if(index == size -1 ){
            return getLast();
        }
        int idx = 0;
        Node iterator = head;
        while(idx != index){
            iterator = iterator.next;
            idx++;
        }
        return iterator.data;
    }

    public void display(){
        Node iterator = this.head;
        while(iterator != null){
            System.out.print(iterator.data+"->");
            iterator = iterator.next;
        }
        System.out.println("END");

    }

    private void handleFirstAddition(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        this.head = node;
        this.tail = node;
        size++;
    }

    private Node getNodeAt(int index) throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        if(index == size || index < 0){
            throw new Exception("Index out of Bounds");
        }

        if(index == 0){
            return head;
        }
        if(index == size -1 ){
            return tail;
        }
        int idx = 0;
        Node iterator = head;
        while(idx != index){
            iterator = iterator.next;
            idx++;
        }
        return iterator;
    }

}