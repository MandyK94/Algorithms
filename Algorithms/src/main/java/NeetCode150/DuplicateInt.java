package NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class DuplicateInt {

	public boolean hasDuplicate(int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int x:nums) {
			
			if(map.get(x)!=null) {
				return true;
			} else {
				map.put(x, 1);
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		DuplicateInt d = new DuplicateInt();
		int[] arr = {1, 3, 4, 6, 2};
		System.out.println(d.hasDuplicate(arr));
	}
	
}
