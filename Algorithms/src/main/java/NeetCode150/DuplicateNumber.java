package NeetCode150;

public class DuplicateNumber {

	public int findDuplicate(int[] nums) {
		
		int fast = 0;
		int slow = 0;
		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			System.out.println(fast+" "+slow);
			if(fast==slow) {
				break;
			}
		}
		int slow2 = 0;
		while(true) {
			if(nums[slow2]==nums[slow]) {
				return nums[slow];
			}
			slow=nums[slow];
			slow2 = nums[slow2];
		}
	}
	
	
	
	public static void main(String[] args) {
		DuplicateNumber d = new DuplicateNumber();
		int[] arr = {1,3,4,2,2};
		
		System.out.println(d.findDuplicate(arr));
	}
}
