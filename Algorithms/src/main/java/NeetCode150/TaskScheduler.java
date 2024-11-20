package NeetCode150;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		
		int time = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		for(char c:tasks) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(char c:map.keySet()) {
			maxHeap.add(map.get(c));
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		while(!maxHeap.isEmpty() || !q.isEmpty()) {
			time++;
			if(maxHeap.isEmpty()) {
				time = q.peek()[1];
			} else {
				int count = maxHeap.poll()-1;
				if(count>0) {
					q.add(new int[] {count, time+n});
				}
			}
			if(!q.isEmpty() && q.peek()[1]==time) {
				maxHeap.add(q.poll()[0]);
			}
		}
		
		return time;
	}
	public static void main(String[] args) {
		char[] tasks = new char[]{'X', 'X', 'Y', 'Y'};
		TaskScheduler ts = new TaskScheduler();
		System.out.println(ts.leastInterval(tasks, 2));
	}
	
}
