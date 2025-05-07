package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

	public static int[][] kClosest(int[][] points, int k) {
		
		//√(x1)2 + (y1)2
		
		PriorityQueue<double[]> queue = new PriorityQueue<double[]>(k, Comparator.comparingDouble(a->-a[1])); 
		
		for(int i=0;i<points.length;i++) {
			double dist = Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
			if(queue.size()<k) {
				queue.add(new double[] {i, dist});
				continue;
			}
			double[] p = queue.peek();
			if(p[1]>=dist && queue.size()>=k) {
				queue.poll();
				queue.add(new double[] {i, dist});
			}
			
		}
		int[][] res = new int[k][2];
		int index=0;
		while(!queue.isEmpty()) {
			int i = (int) queue.poll()[0];
			res[index][0] = points[i][0];
			res[index][1] = points[i][1];
			index++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] points = {{68,97}, {34,-84}, {60,100}, {2,31}, {-27,-38}, {-73,-74}, {-55,-39}, {62,91}, {62,92}, {-57,-67}};
		int k=5;
		int[][] res = kClosest(points, k);
		for(int[] r:res) {
			System.out.println(r[0]+" "+r[1]);
		}
		
		
	}
	
}
