package LeetCode;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        } 
        int oldValue = x;
        int reverseX = 0;
        while(x>0) {
        	int digit = x%10;
        	x/=10;
        	reverseX*=10;
        	reverseX+=digit;
        }
        System.out.println(reverseX);
        return reverseX==oldValue;
    }
	

	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(121));

	}
}
