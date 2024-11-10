package NeetCode150;

public class ClimbingStairs {

	
	public static int ways(int n) {
		
		int count = 0;
		for(int i=0, v=n, t=0;i<n&&v>=0;i++) {
			System.out.println("i "+i+" v "+v+" t "+t);
			count+=(factorial(n-i)/(factorial(v)*factorial(t)));
			System.out.println("count "+count);
			v-=2;
			t++;
		}
		
		
		return count;
	}
	
	
	private static int factorial(int n) {
		if(n==1||n==0) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	
	public static void main(String[] args) {
		System.out.println(ClimbingStairs.ways(14));
		//System.out.println(factorial(2));
	}
}
