package bit_manipulation;

public class BitOps {
    public static void main(String[] args) {
        System.err.println(Integer.toBinaryString(57));
        System.out.println(Integer.toBinaryString(turnOnBit(57, 2)));
        System.out.println(Integer.toBinaryString(turnOffBit(57, 3)));
        System.out.println(Integer.toBinaryString(toggleBit(57, 2)));
    }

    private static int turnOnBit(int n, int k){
        int mask = 1<<k;
        int num = n | mask;
        return num;
    }

    private static int turnOffBit(int n, int k){
        int mask = 1<<k;
        int revMask = ~mask;
        int num = n&revMask;
        return num;
    }

    private static int toggleBit(int n, int k){
        int mask = 1<<k;
        int num = n ^ mask;
        return num;
    }
}