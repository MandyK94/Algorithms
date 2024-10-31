package NeetCode150;

public class TwoIntSum {

	
	public int[] twoSum(int[] numbers, int target) {
		
		int l=0, r=numbers.length-1;
		
		while(l<r) {
			int curSum = numbers[l]+numbers[r];
			if(curSum<target) {
				l++;
			} else if(curSum>target) {
				r--;
			} else {
				return new int[] {l+1, r+1};
			}
		}
		
		return new int[0];
	
    }
	
	public static void main(String[] args) {
		
	}
}
