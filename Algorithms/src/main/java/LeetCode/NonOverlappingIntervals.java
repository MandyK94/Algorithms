package LeetCode;

import java.util.Arrays;

public class NonOverlappingIntervals {
	
	public static int eraseOverlapIntervals(int[][] intervals) {
	
		Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
		int end = intervals[0][1];
		int count = 0;
		for(int i=1;i<intervals.length;i++) {
			
			int[] currInterval = intervals[i];
			if(end>currInterval[0]) {
				count++;
				end=Math.min(end, currInterval[1]);
			} else {
				end=currInterval[1];
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] intervals = {
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 3}
		};
		System.out.println(eraseOverlapIntervals(intervals));
	}

}
