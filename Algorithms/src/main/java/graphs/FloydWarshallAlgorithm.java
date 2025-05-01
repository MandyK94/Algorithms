package graphs;

public class FloydWarshallAlgorithm {

	static int[][] floydWarshall(int[][] dist){
		int V = dist.length;
		int INF = Integer.MAX_VALUE;
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					if(dist[i][k]!=INF && dist[k][j]!=INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		int INF = Integer.MAX_VALUE;
		int[][] dist = { { 0, 4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 } };
		
		int[][] res = floydWarshall(dist);
		
		for(int[] row:res) {
			for(int v: row) {
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}
