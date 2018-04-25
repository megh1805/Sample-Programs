package program_challenge;

public class Palindrome {
    public static boolean isPalindrome(String word) {
    	StringBuffer x= new StringBuffer(word);
    	x.reverse();
    	if (!word.equalsIgnoreCase(x.toString()))
    		return false;
       return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
