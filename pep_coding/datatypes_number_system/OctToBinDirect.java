package pep_coding.datatypes_number_system;

public class OctToBinDirect {

    public static void main(String[] args) {
        int bin = octToBinDirect(542);
        System.out.println(bin);
        System.out.println(binToOctDirect(bin));
    }

    public static int octToBinDirect(int oct) {
        int bin = 0;
        int temp = oct;
        int place = 1;
        while (temp != 0) {
            int lastDig = temp % 10;
            temp /= 10;
            int subBin = 0;
            switch (lastDig) {
                case 0:
                    subBin = 0;
                    break;
                case 1:
                    subBin = 1;
                    break;
                case 2:
                    subBin = 10;
                    break;
                case 3:
                    subBin = 11;
                    break;
                case 4:
                    subBin = 100;
                    break;
                case 5:
                    subBin = 101;
                    break;
                case 6:
                    subBin = 110;
                    break;
                case 7:
                    subBin = 111;
                    break;
            }
            bin+=subBin*place;
            place *= 1000;
        }

        return bin;
    }

    public static int binToOctDirect(int bin) {
        int oct = 0;
        int temp = bin;
        int place = 1;
        while (temp != 0) {
            int lastGroup = temp % 1000;
            temp /= 1000;
            int subOct = 0;
            switch (lastGroup) {
                case 0:
                    subOct = 0;
                    break;
                case 1:
                    subOct = 1;
                    break;
                case 10:
                    subOct = 2;
                    break;
                case 11:
                    subOct = 3;
                    break;
                case 100:
                    subOct = 4;
                    break;
                case 101:
                    subOct = 5;
                    break;
                case 110:
                    subOct = 6;
                    break;
                case 111:
                    subOct = 7;
                    break;
            }
            oct+=subOct*place;
            place *= 10;
        }

        return oct;
    }

}