package pep_coding.recursion;

import java.util.ArrayList;

public class RecurOps {

    public static void main(String[] args) {
        System.out.println(getSubSequences("abc"));
        System.out.println(getSubSequencesAscii("abc"));
        System.out.println(getKPC("17"));
        printSubSequences("abc", "");
        printKPC("17", "");
    }

    public static void printSubSequences(String str, String asf){
        if(str.isEmpty()){
            System.out.println(asf);
            return;
        }
        printSubSequences(str.substring(1), asf);
        printSubSequences(str.substring(1), asf+str.charAt(0));
    }

    static String[] numPad = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz" };

    public static void printKPC(String str, String asf){

        if(str.isEmpty()){
            System.out.println(asf);
            return;
        }

        int num = str.charAt(0) - 48;
        String ros = str.substring(1);

        String codes = numPad[num];
        for (char ch : codes.toCharArray()) {
            printKPC(ros, asf+ch);
        }
    }

    public static ArrayList<String> getKPC(String str){
        if (str.isEmpty()) {
            ArrayList<String> bl = new ArrayList<>();
            bl.add(" ");
            return bl;
        }
        int num = str.charAt(0) - 48;
        String ros = str.substring(1);
        ArrayList<String> rr = getKPC(ros);
        ArrayList<String> myList = new ArrayList<>();;
        String combinations = numPad[num];
        for(char c : combinations.toCharArray()){
            for (String string : rr) {
                myList.add(c+string);
            }
        }
        return myList;
    }

    public static ArrayList<String> getSubSequences(String str) {

        if (str.isEmpty()) {
            ArrayList<String> bl = new ArrayList<>();
            bl.add(" ");
            return bl;
        }

        ArrayList<String> subList = getSubSequences(str.substring(1));
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(subList);
        for (String string : subList) {
            newList.add(str.charAt(0) + string);
        }
        return newList;
    }

    public static ArrayList<String> getSubSequencesAscii(String str) {

        if (str.isEmpty()) {
            ArrayList<String> bl = new ArrayList<>();
            bl.add(" ");
            return bl;
        }

        ArrayList<String> subList = getSubSequencesAscii(str.substring(1));
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(subList);
        for (String string : subList) {
            newList.add(str.charAt(0) + string);
            newList.add(((int) str.charAt(0)) + string);
        }
        return newList;
    }
}