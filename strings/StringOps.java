package strings;

public class StringOps {
    
    public static void main(String[] args) {
        // printSubStrings("hello");
        // System.out.println("is hello pallindrome "+isPallindrome("hello"));
        // System.out.println("is nitin pallindrome "+isPallindrome("nitin"));
        printPallindromicSS("abccba");
    }
    // time complexity O(n^3)
    private static void printSubStrings(String string){
        int len = string.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                System.out.println(string.substring(i, j));
            }
        }
    }

    private static boolean isPallindrome(String str){
        int left = 0;
        int right = str.length() -1;
        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    private static void printPallindromicSS(String str){
        int len = str.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String sub = str.substring(i, j);
                if(isPallindrome(sub)){
                    System.out.println(sub);
                }
            }
        }
    }
}