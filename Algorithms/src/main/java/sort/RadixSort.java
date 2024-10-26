package sort;

public class RadixSort {

	
	public static int[] sort(int[] arr) {
		
		//Find the max value;
		int max = Integer.MIN_VALUE;
		for(int x:arr) {
			if(max<x) {
				max=x;
			}
		}
		
		for(int i= 1; max/i>0;i*=10) {
			arr = countSort(arr, i);	
		}
		
		return arr;
	}
	
	
	private static int[] countSort(int[] arr, int exp) {
		
		int[] countArray = new int[10];
		int[] sortedArray = new int[arr.length];
		
		
		
		// count elements
		for(int i=0;i<arr.length;i++) {
			countArray[(arr[i]/exp)%10] ++;
		}
		
		//Cumulative array
		for(int i =1;i<10;i++) {
			countArray[i]+=countArray[i-1];
		}
		
		//SortedArray
		for(int i=arr.length-1;i>=0;i--) {
			sortedArray[countArray[(arr[i]/exp)%10]-1] = arr[i];
			countArray[(arr[i]/exp)%10]--;
		}
		
		return sortedArray;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {200, 4, 66, 78, 99, 2, 1000, 201};
		int[] b = RadixSort.sort(a);
		for(int x:b) {
			System.out.println(x);
		}
		
	}
}
