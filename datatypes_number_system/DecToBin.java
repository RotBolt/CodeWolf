package datatypes_number_system;

import java.util.Scanner;

public class DecToBin {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int dec = in.nextInt();
        in.close();
        int bin = decToBin(dec);
        System.out.println(bin);
        System.out.println(binToDec(bin));

    }

    public static int decToBin(final int decimal) {
        int temp = decimal;
        int bin = 0;
        int place = 1;
        while (temp != 0) {
            final int r = temp % 2;
            temp/=2; 
            bin = bin + (r*place);
            place*=10;
        }
        return bin;
    }

    public static int binToDec(int bin){
        int temp = bin;
        int dec = 0;
        int place = 1;
        while(temp != 0){
            int r = temp%10;
            temp/=10;
            dec+=r*place;
            place*=2;
        }
        return dec;
    }
    
}