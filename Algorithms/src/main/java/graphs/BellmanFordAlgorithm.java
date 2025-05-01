package graphs;

import java.util.Arrays;

public class BellmanFordAlgorithm {

	
	public static int[] bellmanFord(int V, int[][] edges, int src) {
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		for(int i=0;i<V;i++) {
			for(int[] edge: edges) {
				int u = edge[0];
				int v = edge[1];
				int d = edge[2];
				
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+d<dist[v]) {
					if(i==V-1) {
						return new int[]{-1};
					} 
					dist[v] = dist[u]+d;
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0, 1, 5}, {1, 2, 1}, {1, 3, 2}, {2, 4, 1}, {4, 3, -1}};
		int src = 0;
		int V = 5;
		int[] res = bellmanFord(V, edges, src);
		for (int x: res) {
			System.out.print(x + " ");
		}
	}
	
}
