package arrays;

public class DutchNationalFlagProblem {

	public static int[] sort(int[] arr) {
		
		int l=0, m=0, h=arr.length-1;
		
		while(m<=h) {
			if(arr[m]==0) {
				arr[m]=arr[l];
				arr[l]=0;
				l++;m++;
			} else if(arr[m] == 1) {
				m++;
			} else {
				arr[m]=arr[h];
				arr[h]=2;
				h--;
			}
		}
		
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 0, 1, 2 };
		arr = DutchNationalFlagProblem.sort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
