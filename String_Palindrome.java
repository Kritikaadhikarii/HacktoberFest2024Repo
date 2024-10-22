public class String_Palindrome {

    public boolean palindrome(String s){
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    

    public static void main(String[] args) {
        String_Palindrome obj = new String_Palindrome();
        System.out.println(obj.palindrome("radar")); 
        System.out.println(obj.palindrome("madam"));
        System.out.println(obj.palindrome("hello"));

    }
    
}
