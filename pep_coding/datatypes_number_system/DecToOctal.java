package pep_coding.datatypes_number_system;

import java.util.Scanner;

public class DecToOctal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dec = in.nextInt();
        in.close();
        int oct = decToOctal(dec);
        System.out.println(oct);
        System.out.println(octToDec(oct));
    }

    public static int decToOctal(int dec){
        int temp = dec;
        int place = 1;
        int oct = 0;
        while(temp != 0){
            int r = temp%8;
            temp/=8;
            oct+=(r*place);
            place*=10;
        }
        return oct;
    }

    public static int octToDec(int oct){
        int temp = oct;
        int place = 1;
        int dec = 0;
        while(temp != 0){
            int r = temp%10;
            temp/=10;
            dec+=(r*place);
            place*=8;
        }
        return dec;
    }
    
}