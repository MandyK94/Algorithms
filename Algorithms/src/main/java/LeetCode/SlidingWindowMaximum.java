package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length+1-k];
		
		Deque<Integer> dq = new ArrayDeque<Integer>(k);
		
		for(int i=0;i<k;i++) {
			while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		
		for(int i=k-1;i<nums.length;i++) {
			res[i-k+1] = nums[dq.peekFirst()];
			while(!dq.isEmpty() && dq.peekFirst()<=i-k+1) {
				dq.pollFirst();
			}
			if(i+1<nums.length) {
				while(!dq.isEmpty() && nums[i+1]>=nums[dq.peekLast()]) {
					dq.pollLast();
				}
				dq.addLast(i+1);
			}
			
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		//int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] nums = {1, -1};
		int[] res = maxSlidingWindow(nums, 1);
		//int[] res = maxSlidingWindow(nums, 3);
		for(int x:res) {
			System.out.print(x+ " ");
		}
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.addLast(4);
		
		//System.out.println(dq.peekLast());
	}
	
}
