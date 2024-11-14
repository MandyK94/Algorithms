package NeetCode150;

public class RotatedSortedArray {
	
	public static int findMin(int[] nums) {
		int num=nums[0];
		
		int l=0;
		int r=nums.length-1;
		while(l<=r) {
			if(nums[l]<nums[r]) {
				num = Math.min(num, nums[l]);
				break;
			}
			int mid = (l+r)/2;
			num=Math.min(num, nums[mid]);
			
			if(nums[mid]>=nums[l]) {
				l=mid+1;
			} else {
				r=mid-1;
			}
		}
		return num;
    }
	
	public  static int search(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			
			if(nums[mid]==target) {
				return mid;
			}
			
			if(nums[l]<=nums[mid]) {
				if(target > nums[mid] || target<nums[l]) {
					l=mid+1;
				} else {
					r=mid-1;
				}
			} else {
				if(target<nums[mid]|| target >nums[r]) {
					r=mid-1;
				} else {
					l=mid+1;
				}
			}
			
		}
		
		return -1;
		
    }
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,4,1};
		System.out.println(findMin(arr));
		System.out.println(search(arr, 1));
	}
}
