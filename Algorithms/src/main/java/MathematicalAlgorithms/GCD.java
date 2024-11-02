package MathematicalAlgorithms;

public class GCD {

	
	public int euclideanGCD(int a, int b) {
		if(a==0)
			return b;
		if(b==0 || a==b)
			return a;
		if(a>b) {
			if(a%b==0) {
				return b;
			}
			return euclideanGCD(a-b, b);
		} else {
			if(b%a==0) {
				return a;
			}
			return euclideanGCD(a, b-a);
		}
	}
	
	
	public int optimizedGCD(int a, int b) {
		if(a==0) {
			return b;
		} 
		if(b==0 ||a==b) {
			return a;
		}
		
		if(a>b) {
			return optimizedGCD(a%b, b);
		} else {
			return optimizedGCD(a, b%a);
		}
	}
	
	public static void main(String[] args) {
		GCD gcd = new GCD();
		System.out.println(gcd.optimizedGCD(8, 56));
	}
}
