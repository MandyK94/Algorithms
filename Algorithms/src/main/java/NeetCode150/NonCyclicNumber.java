package NeetCode150;

import java.util.HashSet;
import java.util.Set;

public class NonCyclicNumber {

	
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = sqaureOfDigits(n);
		while(sum!=1 ) {
			if(set.contains(sum)) {
				return false;
			}
			set.add(sum);
			sum = sqaureOfDigits(sum);
			
		}
		return true;
    }
	
	
	private static int sqaureOfDigits(int num) {
		int sum =0;
		int digit;
		while(num!=0) {
			digit = num%10;
			num = num/10;
			sum += digit*digit;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(NonCyclicNumber.isHappy(10));
	}
}
