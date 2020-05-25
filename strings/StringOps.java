package strings;

public class StringOps {
    
    public static void main(String[] args) {
        // printSubStrings("hello");
        // System.out.println("is hello pallindrome "+isPallindrome("hello"));
        // System.out.println("is nitin pallindrome "+isPallindrome("nitin"));
        // printPallindromicSS("abccba");
        // System.out.println(insertAsciiDiff("abbbcdi"));
        // System.out.println(compress("aaaabbbbbbcdiiiii"));
        printSubSequence("abc");
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

    private static String insertAsciiDiff(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i=0;i<len-1;i++){
            char c = str.charAt(i);
            char nc = str.charAt(i+1);
            sb.append(c).append(nc-c);
        }
        sb.append(str.charAt(len-1));
        return sb.toString();
    }

    private static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        char curr = str.charAt(0);
        int count = 1;
        for(int i = 1; i< len;i++){
            char mc = str.charAt(i);
            if(curr == mc){
                count++;
            }else{
                sb.append(curr);
                if(count > 1){
                    sb.append(count);
                }
                curr=mc;
                count=1;
            }
        }
        sb.append(str.charAt(len-1));
        if(count > 1){
            sb.append(count);
        }
        return sb.toString();
    }

    private static void printSubSequence(String str){
        int noOfSS = 1<<str.length();
        for(int i = 0; i< noOfSS ;i++){
            for(int j = str.length() - 1;j>=0;j--){
                int mask = 1<<j;
                if((i&mask)!=0){ // jth bit on
                    System.out.print(str.charAt(str.length() - 1 -j));
                }
            }
            System.out.println();
        }
    }
}