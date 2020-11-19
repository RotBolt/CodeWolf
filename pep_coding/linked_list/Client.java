package pep_coding.linked_list;

public class Client {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.addFirst(8);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.addFirst(5);
        list.addFirst(3);

        list.display();

        System.out.println(list.getAt(3));
        System.out.println(list.getAt(0));

        list.addAt(5, 25);
        list.addAt(2, 7);
        list.display();

        list.removeFirst();
        list.display();

        list.removeLast();
        list.display();

        list.removeAt(3);
        list.display();
        System.out.println("List size "+list.getSize());

        list.reverseDataIteratively();
        list.display();

        list.reversePointerIteratively();
        list.display();

        list.reversePointerRecursively();
        list.display();

        System.out.println(list.isPallindromic());

        LinkedList pallin = new LinkedList();
        pallin.addLast(1);
        pallin.addLast(2);
        pallin.addLast(3);
        pallin.addLast(2);
        pallin.addLast(1);
        System.out.println(pallin.isPallindromic());

        list.removeLast();
        list.fold();
        list.display();

        System.out.println(list.kthNodeFromLast(3));

        System.out.println(list.getMidNodeData());

        list.kReverse(2);
        list.display();

        list.convertToOddEvenList();
        list.display();

        LinkedList sorted = LinkedList.mergeSort(list);
        sorted.display();
    }
    
}