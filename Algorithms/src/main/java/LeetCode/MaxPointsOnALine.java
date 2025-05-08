package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public static int maxPoints(int[][] points) {
		
		int maxPoints=1;
		
		for(int i=0;i<points.length;i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int j=0;j<points.length;j++) {
				if(i==j) {
					continue;
				}
				int x2 = points[j][0];
				int y2 = points[j][1];
				int dx = x2-x1;
				int dy = y2-y1;
				int gcd = gcd(dx, dy);
				String slope = dx/gcd + "/" + dy/gcd;
				map.put(slope, map.getOrDefault(slope, 0)+1);
				maxPoints = Math.max(maxPoints, map.get(slope)+1);
			}
		}
		return maxPoints;
	}
	
	private static int gcd(int a, int b) {
		return b==0?a:gcd(b, a%b);
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,1}, {2,2}, {3,3}};
		System.out.println(maxPoints(points));
	}
	
}
