package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeastNeighbourCity {

	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int INF = Integer.MAX_VALUE;
        int counter = 0;
        for(int[] row: dist) {
        	Arrays.fill(row, INF);
        	row[counter]=0;
        	counter++;
        }
        for(int[] edge:edges) {
        	dist[edge[0]][edge[1]] = edge[2];
        	dist[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k=0;k<n;k++) {
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			if(dist[i][k]!=INF && dist[k][j]!=INF) {
        				dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
        			}
        		}
        	}
        }
        
        for(int[] row:dist) {
			for(int v: row) {
				System.out.print(v+" ");
			}
			System.out.println();
		}
       
        int fewNCity = -1;
        int fewCount = n;
        for(int i=0;i<n;i++) {
        	int count = 0;
        	for(int j=0;j<n;j++) {
        		if(i!=j && dist[i][j]<=distanceThreshold) {
        			count++;
        		}
        	}
        	if(count<=fewCount) {
        		fewNCity = i;
        		fewCount = count;
        	}
        }
        return fewNCity;
    }
	
	
	public static void main(String[] args) {
		int n=4;
		//int[][] edges = {{0,1,2}, {0,4,8}, {1,2,3}, {1,4,2}, {2,3,1}, {3,4,1}}; 
		int[][] edges = {{0,1,3}, {1,2,1}, {1,3,4}, {2,3,1}};
		int th = 4;
		
		System.out.println(findTheCity(n, edges, th));
	}
	
}
