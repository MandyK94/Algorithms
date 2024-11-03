package MathematicalAlgorithms;

public class PrimeNumbers {

	
	public static boolean isPrime(int num) {
		
		if(num==2||num==3) {
			return true;
		}
		
		if(num%2==0||num%3==0) {
			return false;
		}
		
		for(int i=5;i*i<num;i+=6*i) {
			if(num%i==0||num%(i+2)==0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(PrimeNumbers.isPrime(1003));
	}
}
