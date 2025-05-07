package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
		
		ArrayList<int[]> stack = new ArrayList<int[]>();
		
		for(int i=0;i<intervals.length;i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			
			
			if(!stack.isEmpty()) {
				int[] lastInterval = stack.getLast();
				if(lastInterval[1]>=start) {
					start = lastInterval[0]; 
					end = Math.max(end, lastInterval[1]);
					stack.removeLast();
				}
			}
			stack.add(new int[] {start, end});
			
		}
		return stack.stream().toArray(int[][]::new);	
	}
	
	
	public static void main(String[] args) {
		int[][] intervals=  {{1, 3}, 
							{2, 6}, 
							{8, 10}, 
							{15, 18}};
		int[][] res= merge(intervals);
		
		for(int[] interval:res) {
			System.out.println(interval[0] + " "+interval[1]);
		}
	}
	
}
