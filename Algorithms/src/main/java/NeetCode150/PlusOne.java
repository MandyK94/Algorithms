package NeetCode150;

public class PlusOne {

	public static int[] plusOne(int[] digits) {
        
		int n=digits.length;
		for(int i=n-1;i>=0;i--){
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			} 
			digits[i]=0;
		}
		int[] res = new int[n+1];
		res[0]=1;
		return res;
    }
	
	
	public static void main(String[] args) {
		int[] digits = {9, 9, 9, 9};
		int[] res = PlusOne.plusOne(digits);
		for(int x:res)
			System.out.print(x);
		
	}
}

