package NeetCode150;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int stone:stones) {
			heap.add(stone);
		}
		
		while(heap.size()>1) {
			int stone1 = heap.poll();
			int stone2 = heap.poll();
			if(stone1>stone2) {
				heap.add(stone1-stone2);
			}
		}
		
		if(heap.size()==1) {
			return heap.poll();
		} else {
			return 0;
		}
	}
}
