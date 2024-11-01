package NeetCode150;

public class TrappingRainWater {
	
	public int trap(int[] height) {
		
		int l=0;
		int r=height.length-1;
		int water = 0;
		
		int rMax=height[r];
		int lMax=height[l];
		while(l<r) {
			if(lMax<=rMax) {
				l++;
				lMax=Math.max(lMax, height[l]);
				if(height[l]<lMax) {
					water+=lMax-height[l];
				}
			} else {
				r--;
				rMax = Math.max(rMax, height[r]);
				if(height[r]<rMax) {
					water+=rMax-height[r];
				}
			}
		}
		
		return water;
	}
	
	
	
	public static void main(String[] args) {
		TrappingRainWater trp = new TrappingRainWater();
		int[] arr = {0,2,0,3,1,0,1,3,2,1};
		System.out.println(trp.trap(arr));
	}
}
