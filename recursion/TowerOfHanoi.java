package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        toh("A", "B", "C", 3);
    }

    public static void toh(String source, String dest, String helper, int nDisks) {
        if (nDisks == 0) {
            return;
        }
        toh(source, helper, dest, nDisks - 1);
        System.out.println("Move " + nDisks + "th disk from " + source + " to " + dest);
        toh(helper, dest, source, nDisks - 1);
    }

}