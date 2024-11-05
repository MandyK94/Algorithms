package NeetCode150;

public class MissingNumber {

	public static int missingNumber(int[] nums) {
		
		int sum=0;
		for(int x:nums) {
			sum+=x;
		}
		
		return (nums.length*(nums.length+1))/2 -sum;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {0, 2};
		System.out.println(MissingNumber.missingNumber(arr));
	}
}
