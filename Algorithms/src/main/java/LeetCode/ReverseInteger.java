package LeetCode;

public class ReverseInteger {

	public int reverse(int x) {
		int reversed = 0;
		boolean negative = x<0?true:false;
		
		x = negative?-x:x;
		while(x>0) {
			if(reversed>Integer.MAX_VALUE/10) {
				return 0;
			}
			reversed=reversed*10 +x%10;
			System.out.println(reversed);
			x/=10;
		}
		
		return negative?-reversed:reversed;
	}
	
	
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(r.reverse(1534236469));
	}
}
