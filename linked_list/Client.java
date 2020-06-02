package linked_list;

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


    }
    
}