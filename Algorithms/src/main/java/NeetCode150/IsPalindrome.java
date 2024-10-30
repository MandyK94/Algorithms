package NeetCode150;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("\\p{Punct}", "").toLowerCase().replace(" ", "");
		System.out.println(s);
		int l = 0;
		int h = s.length()-1;
		while(l<h) {
			System.out.println(s.charAt(l)+" "+s.charAt(h));
			if(s.charAt(l++)!=s.charAt(h--)) {
				System.out.println(s.charAt(l)+" "+s.charAt(h));
				return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		IsPalindrome isp= new IsPalindrome();
		System.out.println(isp.isPalindrome("Was it a car or a cat I saw"));
	}
}
