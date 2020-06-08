package generic_tree;

public class Client {

    // 10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
    public static void main(String[] args) {
        GenericTree tree = new GenericTree();
        tree.display();
        System.out.println("Size "+tree.size());

        System.out.println("Calc Size "+tree.calculateSize());
    }
    
}