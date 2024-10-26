package sort;

public class CountingSort {

	
	public static int[] sort(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		// Find the max value
		for(int x:arr) {
			if(max<x) {
				max = x;
			}
		}
		int[] countArray = new int[max+1];
		// Count the values
		for(int x:arr) {
			countArray[x]++;
		}
		// Cumulative sum
		for(int i=1;i<=max;i++) {
			countArray[i] += countArray[i-1];
		}
		
		// Sorted array
		int[] sortedArray = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			sortedArray[countArray[arr[i]]-1] = arr[i];
			countArray[arr[i]]--;
		}
		
		
		return sortedArray;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 4, 5, 3, 7, 2, 7, 8, 0, 5};
		int[] b = CountingSort.sort(a);
		for (int x:b) {
			System.out.println(x);
		}
	}
}
