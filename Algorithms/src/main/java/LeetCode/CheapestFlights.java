package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlights {

	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, src, 0 });

        while (!q.isEmpty()) {
            var curr = q.poll();
            int cst = curr[0], node = curr[1], stops = curr[2];
            if (stops > k) continue;

            for (var neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCost = cst + w;
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    q.offer(new int[] { nextCost, nei, stops + 1 });
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}
	
	public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
		
		// priority queue : [distance, node, stops]
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
		// preprocessing [next node, distance]
		List<List<List<Integer>>> graph = arrayToGraph(flights, n);
		
		// an array to keep track of the distance
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		// add src to queue
		ArrayList<Integer> first = new ArrayList<Integer>();
		Collections.addAll(first, 0, src, 0);
		queue.offer(first);
		
		while(!queue.isEmpty()) {
			// take the node with minimum distance from queue
			ArrayList<Integer> node = queue.poll();
			int currDist = node.get(0), currNode = node.get(1), currStops = node.get(2);
			if(currStops == k+1) continue;
			
			// visit all the neighbours of this node
			for(List<Integer> neighbour: graph.get(currNode)) {
				int nextNode= neighbour.get(0), w = neighbour.get(1);
				int nextDist = w+currDist;
				if(dist[nextNode]>nextDist) {
					dist[nextNode]=nextDist;
					ArrayList<Integer> next = new ArrayList<Integer>();
					Collections.addAll(next, nextDist, nextNode, currStops+1);
					queue.offer(next);
				}
			}
		}
		return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
	}
	
	
	
	private static List<List<List<Integer>>> arrayToGraph(int[][] data, int n) {
		List<List<List<Integer>>> nodes = new ArrayList<List<List<Integer>>>();
		for(int i=0;i<n;i++) {
			nodes.add(new ArrayList<List<Integer>>());
		}
		for(int[] val:data) {
			List<Integer> node = new ArrayList<Integer>();
			node.add(val[1]);
			node.add(val[2]);
			List<List<Integer>> list = nodes.get(val[0]);
			list.add(node);
		}	
		return nodes;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}}; 
		int src = 0, dst = 2, k = 2;
		int res = findCheapestPrice1(n, flights, src, dst, k);
		System.out.println(res);
	}
	
}
