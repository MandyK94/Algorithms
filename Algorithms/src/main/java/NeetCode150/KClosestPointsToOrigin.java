package NeetCode150;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>( Comparator.comparing(a -> (a[0]*a[0]+a[1]*a[1])));
		for(int[] point: points) {
			heap.add(new Integer[] {point[0], point[1]});
		}
		int[][] res = new int[k][2];
		for(int i=0;i<k;i++) {
			res[i][0]=heap.peek()[0];
			res[i][1]=heap.peek()[1];
			heap.poll();
		}
		return res;
	}
}
