package NeetCode150;

public class TwoSum {

public int[] twoSum(int[] nums, int target) {
		
        for(int i=0;i<nums.length;i++) {
        	int rem = target - nums[i];
    		for(int j=i+1;j<nums.length;j++) {
    			if(nums[j]==rem) {
    				int[] arr = {i, j};
    				return arr;
    			}
    		}
        }
        return null;
    }

	public static void main(String args[]) {
		TwoSum t = new TwoSum();
		int[] a = {3,2,3};
		int[] result = t.twoSum(a, 6);
		System.out.println(result[0]+" "+result[1]);
	}


}
