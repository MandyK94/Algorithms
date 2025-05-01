package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	
	private static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges, int V) {
		
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for(int i=0;i<V+1;i++) {
			adj.add(new ArrayList<ArrayList<Integer>>());
		}
		
		//Fill the adjacency list from edges
		for(int[] edge:edges) {
			int u=edge[0];
			int v=edge[1];
			int w=edge[2];
			
			ArrayList<Integer> e1 = new ArrayList<Integer>();
			e1.add(v);
			e1.add(w);
			adj.get(u).add(e1);
		}
		return adj;
	}

	public static int networkDelayTime(int[][] times, int n, int k) {
		
		// Adj graph
		ArrayList<ArrayList<ArrayList<Integer>>> adj  = constructAdj(times, n);
		// Min distance array: initiated at +ve Inf and source as 0
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		//dummy node
		dist[0] = -1;
		// Queue [distance, Node]
		PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<ArrayList<Integer>>(Comparator.comparingInt(a->a.get(0))); 
		
		// Put src node to queue
		ArrayList<Integer> src = new ArrayList<Integer>();
		src.add(0);
		src.add(k);
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> node = queue.poll();
			int u = node.get(1);
			int d = node.get(0);
			for(ArrayList<Integer> neighbour: adj.get(u)) {
				int v = neighbour.get(0);
				int w = neighbour.get(1);
				
				if(d+w < dist[v]) {
					dist[v] = d+w;
					ArrayList<Integer> next = new ArrayList<Integer>();
					next.add(d+w);
					next.add(v);
					queue.offer(next);
				}
			}
		}
		
		int res = Arrays.stream(dist).max().getAsInt(); 
		return res==Integer.MAX_VALUE?-1:res;
    }
	
	
	public static void main(String[] args) {
		int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
		int n=4, k=2;
		System.out.println(networkDelayTime(times, n, k));
	}
}
