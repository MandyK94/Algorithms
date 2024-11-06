package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeIntSum {

	/* Given an integer array nums, 
	 * return all the triplets [nums[i], nums[j], nums[k]] 
	 * where nums[i] + nums[j] + nums[k] == 0, 
	 * and the indices i, j and k are all distinct.
	 */
	
	
	
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		// use each number to add to the sum of other two numbers that makes it zero
		for(int i=0;i<nums.length;i++) {
			// to avoid calculating duplicates
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			// use two pointers to find the other two values
			int l=i+1;  
			int r=nums.length-1;
			while(l<r) {
				if(nums[i]+nums[l]+nums[r] >0) {
					r--;
				} else if(nums[i]+nums[l]+nums[r] <0) {
					l++;
				} else {
					System.out.println(i+" "+l+" "+r);
					List<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[i]);
					triplet.add(nums[l]);
					triplet.add(nums[r]);
					list.add(triplet);
					l++;
					while(l<r && nums[l]==nums[l-1]) {
						l++;
					}
					r--;
				}
			}
		}
		
		return list;
		
	}
	
	
	
	
	public List<List<Integer>> threeSum1(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		
		for(int i=0;i<nums.length;i++) {
			int l=0, r=nums.length-1;
			int sum;
			while(l<r) {
				System.out.println(i+" "+l+" "+r);
				if(l==i) {
					l++;
				} else if(r==i) {
					r--;
				}
				if(i>0 && nums[i]==nums[i-1]) {
					continue;
				}
				sum = nums[i]+nums[l]+nums[r];
				if(sum>0) {
					r--;
				} else if(sum<0) {
					l++;
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					System.out.println(i+" "+l+" "+r);
					triplets.add(list);
					break;
				}
				
			}
		}
		
		return triplets;
        
    }
	
	public static void main(String[] args) {
		
		ThreeIntSum tis = new ThreeIntSum();
		int[] arr = {-2,0,0,2,2};
		System.out.println(tis.threeSum(arr));
	}
}
