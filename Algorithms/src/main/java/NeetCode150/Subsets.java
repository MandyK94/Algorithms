package NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<Integer>();
		dfs(subset, nums, 0, res);
		
		return res;
		
	}
	
	private void dfs(List<Integer> subset, int[] nums, int index, List<List<Integer>> res) {
		if(index>=nums.length) {
			
			res.add(new ArrayList<>(subset));
			return;
		}
		subset.add(nums[index]);
		dfs(subset, nums, index+1, res);
		subset.remove(subset.size()-1);
		dfs(subset, nums, index+1, res);
	}
	
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = {1, 2, 3};
		System.out.println(s.subsets(nums));
	}
	
}
