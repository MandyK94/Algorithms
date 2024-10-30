package NeetCode150;

public class BinarySearch {
	public int search(int[] nums, int target) {
    
		int low = 0; 
		int high = nums.length-1;
		
		int index = low;
		
		if(nums.length==1 && nums[0]==target) {
			return 0;
		}
		
		while(low<=high) {
			index=(high+low)/2;
			System.out.println("low: "+low+", index: "+ index+", high: "+high);
			if(nums[index]==target) {
				return index;
			} else if(nums[index]<target) {
				low=index+1;
			} else {
				high=index-1;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = {-1,0,3,5,9,12}; 
		System.out.println(bs.search(arr, 13));
		
		
	}
	
	
}
