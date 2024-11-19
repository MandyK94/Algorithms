package NeetCode150;

import java.util.PriorityQueue;

public class KthLargest {
	
	private PriorityQueue<Integer> heap;
    int k;

	public KthLargest(int k, int[] nums) {
        this.k=k;
        heap = new PriorityQueue<Integer>();
        for(int num:nums) {
        	heap.add(num);
        }
        
        while(heap.size()>k) {
        	heap.poll();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size()>k){
            heap.poll();
        }
        return heap.peek();
    }
}
