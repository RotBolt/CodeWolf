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

    //o(1)
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

    // o(1)
    public void addFirst(int data) {
        if (isEmpty()) {
            handleFirstAddition(data);
            return;
        }
        Node node = new Node();
        node.data = data;
        node.next = this.head;

        this.head = node;

        this.size++;

    }

    // o(n)
    public void addAt(int index, int data) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        if (index > size || index < 0) {
            throw new Exception("Index out of Bounds");
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size) {
            addLast(data);
        }

        Node item = getNodeAt(index - 1);
        Node node = new Node();
        node.data = data;

        node.next = item.next;
        item.next = node;
        size++;

    }

    // o(1)
    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        return this.head.data;
    }

    // o(1)
    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        return this.tail.data;
    }

    // o(n)
    public int getAt(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        if (index == size || index < 0) {
            throw new Exception("Index out of Bounds");
        }

        if (index == 0) {
            return getFirst();
        }
        if (index == size - 1) {
            return getLast();
        }
        int idx = 0;
        Node iterator = head;
        while (idx != index) {
            iterator = iterator.next;
            idx++;
        }
        return iterator.data;
    }

    // o(1)
    public int removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        } else if (this.size == 1) {
            return handleRemovalWhenSize1();
        } else {
            int data = this.head.data;
            Node currHead = head;
            Node nextHead = head.next;
            head = nextHead;
            currHead.next = null;
            size--;
            return data;
        }
    }

    // o(n)
    public int removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        } else if (this.size == 1) {
            return handleRemovalWhenSize1();
        } else {
            int data = tail.data;
            Node nextTail = getNodeAt(size - 2);
            nextTail.next = null;
            this.tail = nextTail;
            size--;
            return data;
        }
    }

    //o(n)
    public int removeAt(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty"); 
        } else if(index <0 || index >=size){
            throw new Exception("Index out of bounds");
        }else if (this.size == 1) {
            return handleRemovalWhenSize1();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node prevNode = getNodeAt(index - 1);
            int data = prevNode.next.data;
            Node nodeToRm = prevNode.next;
            prevNode.next = nodeToRm.next;
            nodeToRm.next = null;
            size --;
            return data;
        }
    }

    // o(n)
    public void display() {
        Node iterator = this.head;
        while (iterator != null) {
            System.out.print(iterator.data + "->");
            iterator = iterator.next;
        }
        System.out.println("END");

    }

    public void displayReverse(){
        displayReverseHelper(this.head);
        System.out.println("END");
    }

    private void displayReverseHelper(Node node){
        if(node == null){
            return;
        }
        displayReverseHelper(node.next);
        System.out.print(node.data+"->");
    }

    // o(n^2)
    public void reverseDataIteratively() throws Exception{
        int left = 0;
        int right = this.size -1;
        while(left < right){
            Node n = getNodeAt(left);
            Node p = getNodeAt(right);

            int temp = n.data;
            n.data = p.data;
            p.data = temp;

            left++;
            right--;
        }
    }

    private class HeapMover{
        Node node;
    }

    // o(n)
    public void reverseDataRecursively(){
        HeapMover left = new HeapMover();
        left.node = head;
        reverseDataRecursiveHelper(left, head, 0);
    }

    private void reverseDataRecursiveHelper(HeapMover left, Node right, int floor){
        if(right == null){
            return;
        }
        reverseDataRecursiveHelper(left, right.next, floor + 1);
        if(floor >= size/2){
            int data = right.data;
            right.data = left.node.data;
            left.node.data = data;
            left.node = left.node.next; 
        }
    }

    // o(n)
    public void reversePointerIteratively(){
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        Node temp = head;
        head = tail;
        tail = temp;
        tail.next=null;
    }


    // o(n)
    public void reversePointerRecursively(){
        reversePointerRecursiveHelper(head);
        Node temp = head;
        head = tail;
        tail = temp;
        tail.next=null;
    }

    private void reversePointerRecursiveHelper(Node node){
        if(node == tail){
            return;
        }
        reversePointerRecursiveHelper(node.next);
        node.next.next = node;
    }

    //o(n)
    public boolean isPallindromic() {
        HeapMover left = new HeapMover();
        left.node = head;
        return isPallindromicHelper(left, head, 0);
    }

    private boolean isPallindromicHelper(HeapMover left, Node right,int floor){
        if(right == null){
            return true;
        }
        boolean result = isPallindromicHelper(left, right.next, floor+1);
        if(result){
            if(left.node.data == right.data){
                left.node = left.node.next;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void fold(){
        HeapMover left = new HeapMover();
        left.node = head;
        foldHelper(left,head,0);
    }

    private void foldHelper(HeapMover left, Node right, int floor){
        if(right == null){
            return;
        }
        foldHelper(left, right.next, floor+1);
        if(floor > size/2){
            Node origNext = left.node.next;
        
            left.node.next = right;
            right.next = origNext;

            left.node = origNext;
        }

        if(floor == this.size/2){
            this.tail = right;
            this.tail.next = null;
        }
    }

    public int kthNodeFromLast(int k){
        Node slow = head;
        Node fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    // o(1)
    private void handleFirstAddition(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        this.head = node;
        this.tail = node;
        size++;
    }

    // o(1)
    private int handleRemovalWhenSize1() {
        int data = this.head.data;
        this.head = this.tail = null;
        this.size--;
        return data;
    }

    // o(n)
    private Node getNodeAt(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        if (index == size || index < 0) {
            throw new Exception("Index out of Bounds");
        }

        if (index == 0) {
            return head;
        }
        if (index == size - 1) {
            return tail;
        }
        int idx = 0;
        Node iterator = head;
        while (idx != index) {
            iterator = iterator.next;
            idx++;
        }
        return iterator;
    }

}