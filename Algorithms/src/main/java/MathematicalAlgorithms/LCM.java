package MathematicalAlgorithms;

import java.util.Arrays;
import java.util.List;

public class LCM {
	
	public int lcm(List<Integer> numbers) {
		
		return numbers.stream().reduce(1, (x, y)->((x*y)/gcd(x, y)));
	}
	
	private int gcd(int x, int y) {
		if(y==0) {
			return x;
		} else {
			return gcd(y, x%y);
		}
	}
	
	
	public static void main(String[] args) {
		LCM l = new LCM();
		List<Integer> arr = Arrays.asList(2, 4, 3, 5);
		System.out.println(l.lcm(arr));
	}
}
