package pep_coding.datatypes_number_system;

import java.util.Scanner;
// Works for base < 10 only
public class DecToAnyBase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int dec = in.nextInt();
        // int destBase = in.nextInt();
        // int num = decToAny(dec, destBase);
        // System.out.println(num);
        // System.out.println(anyToDec(num, destBase));

        int num1 = in.nextInt();
        int srcBase = in.nextInt();
        int destBase1 = in.nextInt();
        in.close();
        System.out.println(anyToAny(num1, srcBase, destBase1));
    }

    public static int decToAny(int dec, int destBase){
        int temp = dec;
        int dest = 0;
        int place = 1;
        while(temp != 0){
            int r = temp%destBase;
            temp/=destBase;
            dest+=r*place;
            place*=10;
        }
        return dest;
    }

    public static int anyToDec(int num, int srcBase){
        int temp = num;
        int dec = 0;
        int place = 1;
        while(temp != 0){
            int r = temp%10;
            temp/=10;
            dec+=r*place;
            place*=srcBase;
        }
        return dec;
    }

    public static int anyToAny(int num, int srcBase, int destBase){
        int dec = anyToDec(num, srcBase);
        System.out.println("Dec "+dec);
        int res = decToAny(dec, destBase);
        return res;
    }
    
}