package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	private static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges, int V) {
		
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for(int i=0;i<V;i++) {
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
	// GeeksForGeeks implementation
	public static int[] dijkstra(int V, int[][] edges, int src) {
		ArrayList<ArrayList<ArrayList<Integer>>> adj  = constructAdj(edges, V);
		
		// queue -> [[distance, node], ...]
		PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<ArrayList<Integer>>(Comparator.comparingInt(a->a.get(0)));
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// Add source with 0 distance
		dist[src] = 0;
		ArrayList<Integer> start = new ArrayList<Integer>();
		start.add(0);
		start.add(src);
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			
			// get the node with minimum distance
			ArrayList<Integer> curr = queue.poll();
			int u = curr.get(1);
			
			// traverse all the adjacent vertices of that node
			for(ArrayList<Integer> neighbour: adj.get(u)) {
				int v = neighbour.get(0);
				int w = neighbour.get(1);
				
				// if the path through current node is shorter
				if(dist[v]>dist[u]+w) {
					dist[v]=dist[u]+w;
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(dist[v]);
					temp.add(v);
					queue.offer(temp);
				}
			}
			
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		int V = 5;
		int src = 0;
		int[][] edges = {
				{0, 1, 4}, {0, 2, 8},
				{1, 4, 6}, {2, 3, 2},
				{3, 4, 10}
		};
		
		int[] result = dijkstra(V, edges, src);
		for(int val:result) {
			System.out.print(val+" ");
		}
	}
	
}
