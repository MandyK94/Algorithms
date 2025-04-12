package LeetCode;

public class MedianOfSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int m = nums1.length;
		int n = nums2.length;
		
		int[] A = nums1;
		int[] B = nums2;
		
		if(A.length>B.length) {
			int[] temp = A;
			A=B;
			B=temp;
		}
		
		int half = (A.length+B.length+1)/2;
		int l=0;
		int r=A.length;
		while(l<=r) {
			int index1 = (l+r)/2;
			int index2 = half-index1;
			
			int Aleft = index1>0?A[index1-1]:Integer.MIN_VALUE;
			int Aright = index1<A.length?A[index1]:Integer.MAX_VALUE;
			
			int Bleft = index2>0?B[index2-1]:Integer.MIN_VALUE;
			int Bright = index2<B.length?B[index2]:Integer.MAX_VALUE;
			
			if(Aleft<=Bright && Bleft<=Aright) {
				if((A.length+B.length)%2!=0) {
					return Math.max(Aleft, Bleft);
				}
				return (Math.max(Aleft, Bleft)+Math.min(Aright, Bright))/2.0;
			} else if(Aleft>Bright) {
				r=index1-1;
			} else {
				l=index1+1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		MedianOfSortedArrays m = new MedianOfSortedArrays();
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}
}
