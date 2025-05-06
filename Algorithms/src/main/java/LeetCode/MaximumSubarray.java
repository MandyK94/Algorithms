package LeetCode;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		
		int maxSum = nums[0];
		int sum = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			sum=Math.max(sum+nums[i], nums[i]);
			maxSum = Math.max(maxSum, sum);
			
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
