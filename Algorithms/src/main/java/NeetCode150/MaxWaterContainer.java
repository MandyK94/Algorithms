package NeetCode150;

public class MaxWaterContainer {

	
	
	public int maxArea(int[] heights) {
		
		int maxWater =0;
		
		int l=0;
		int r=heights.length-1;
		
		while(l<r) {
			maxWater = Math.max(Math.min(heights[l], heights[r])*(r-l), maxWater);
			if(heights[l]<=heights[r]) {
				l++;
			} else {
				r--;
			}
		}
		
		return maxWater;
		
	}
	
	
	public static void main(String[] args) {
		int[] heights = {1,7,2,5,4,7,3,6};
		MaxWaterContainer w = new MaxWaterContainer();
		System.out.println(w.maxArea(heights));
	}
}
