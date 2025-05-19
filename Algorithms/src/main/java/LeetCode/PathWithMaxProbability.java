package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMaxProbability {

	public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		
		ArrayList<ArrayList<ArrayList<Double>>> adj = new ArrayList<ArrayList<ArrayList<Double>>>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<ArrayList<Double>>());
		}
		for(int i=0;i<edges.length;i++) {
			int[] e = edges[i];
			int u = e[0];
			int v = e[1];
			double p = succProb[i];
			ArrayList<Double> l1 = new ArrayList<Double>();
			l1.add(Double.valueOf(v));
			l1.add(p);
			adj.get(u).add(l1);
			ArrayList<Double> l2 = new ArrayList<Double>();
			l2.add(Double.valueOf(u));
			l2.add(p);
			adj.get(v).add(l2);
			
		}
		
		
		PriorityQueue<Double[]> pq = new PriorityQueue<Double[]>(Comparator.comparingDouble(a->-a[1]));
		
		double[] dist = new double[n];
		Arrays.fill(dist, -1);
		
		dist[start_node] = 1.0;
		
		Double[] startNode = {1.0, Double.valueOf(start_node)};
		pq.offer(startNode);
		
		while(!pq.isEmpty()) {
			System.out.println(pq);
			Double[] node = pq.poll();
			double u = node[1];
			double prob = node[0];
			
			for(ArrayList<Double> neighbour: adj.get((int)u)) {
				double v = neighbour.get(0);
				double p = neighbour.get(1);
				if(p*prob>=dist[(int)v]) {
					dist[(int)v] = p*prob;
					Double[] newNode = {p*prob, v};
					pq.offer(newNode);
				}
			}
		}
		
		return dist[end_node];
	}
	
	public static void main(String[] args) {
		int n=3;
		int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
		double[] succProb = {0.5,0.5,0.2};
		int start = 0, end = 2;
		System.out.println(maxProbability(n, edges, succProb, start, end));
	}
}
