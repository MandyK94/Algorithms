package NeetCode150;

import java.util.Arrays;

public class EatingBananas {

	public static int minEatingSpeed(int[] piles, int h) {
        int k=0;
        
        int r = Arrays.stream(piles).max().getAsInt();
        int l=1;
        while(l<=r) {
        	int hours=0;
        	int mid = (l+r)/2;
        	for(int p:piles) {
        		hours+=Math.ceil((double)p/mid);
        	}
        	if(hours<=h) {
        		r=mid-1;
        		k=mid;
        	} else {
        		l=mid+1;
        	}
        }
        return k;
    }
	public static void main(String[] args) {
		
		int[] piles = {25,10,23,4};
		int h=4;
		
		System.out.println(minEatingSpeed(piles, h));
	}
}
