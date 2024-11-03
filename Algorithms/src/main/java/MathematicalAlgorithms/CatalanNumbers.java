package MathematicalAlgorithms;

public class CatalanNumbers {
	
	
	public static int catalanNumber(int num) {
		
		/*
		 * (2n)! / (n+1)!n!
		 */
		
		if(num==0||num==1) {
			return 1;
		} 
		int result = 0;
		for(int i=0;i<num;i++) {
			result+=catalanNumber(i)*catalanNumber(num-i-1);
		}
		return result;
	}

	
	public static int dynamicProgCatalanNum(int num) {
		int[] catalan = new int[num+2];
		catalan[0]=1;
		catalan[1]=1;
		
		for(int i=2;i<=num;i++) {
			
			for(int j=0;j<i;j++) {
				catalan[i]+=catalan[j]*catalan[i-j-1];
			}
		}
		return catalan[num];
	}
	public static void main(String[] args) {
		System.out.println(CatalanNumbers.dynamicProgCatalanNum(6));
	}
}
