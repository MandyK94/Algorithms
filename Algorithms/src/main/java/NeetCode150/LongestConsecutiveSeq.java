package NeetCode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSeq {

	public int longestConsecutive1(int[] nums) {

		if(nums.length<1) {
			return 0;
		} else if(nums.length==1) {
			return 1;
		}
		
		Arrays.sort(nums);
		
		int maxSteak = 1;
		int lastElement = nums[0];
		int streak = 1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]-lastElement==1) {
				streak++;
				if(streak>maxSteak) {
					maxSteak=streak;
				}
			} else if(nums[i]==lastElement) {
				continue;
			} else {
				streak=1;
			}
			lastElement = nums[i];
		}
		
		return maxSteak;
	}
	
	public int longestConsecutive2(int[] nums) {
		
		if(nums.length==0) {
			return 0;
		} else if(nums.length==1) {
			return 1;
		}
		
		Set<Integer> numSet = new HashSet<Integer>();
		for(int n:nums) {
			numSet.add(n);
		}
		
		int longest = 1;
		int streak;
		int curr;
		for(int n:nums) {
			if(numSet.contains(n-1)) {
				continue;
			}
			curr=n;
			streak=1;
			while(numSet.contains(curr+1)) {
				streak++;
				curr++;
				longest = Math.max(streak, longest);
			}
		}
		
		return longest;
	}
	
	
	public int longestConsecutive3(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res= 0;
		for(int n:nums) {
			if(!map.containsKey(n)) {
				map.put(n, map.getOrDefault(n-1, 0)+map.getOrDefault(n+1, 0)+1);
				map.put(n-map.getOrDefault(n-1, 0),map.get(n));
				map.put(n+map.getOrDefault(n+1, 0),map.get(n));
				res=Math.max(map.get(n), res);
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		LongestConsecutiveSeq lcs = new LongestConsecutiveSeq();
		int[] nums = {2,20,4,10,3,4,5};
		System.out.println(lcs.longestConsecutive1(nums));
	}
}
