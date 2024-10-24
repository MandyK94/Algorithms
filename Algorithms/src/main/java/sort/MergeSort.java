package sort;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] arr, int low, int high) {
		// Find the mid index
		int mid = (int)((low+high)/2);
		if(low <high) {
			// call recursive sort on both arrays
			sort(arr, low, mid);
			sort(arr, mid+1, high);
		}
		// merge the arrays
		merge(arr, low, high);
		
		
	}
	
	private static void merge(int[] arr, int low, int high) {
		// Find the mid index val
		int mid = (int)((low+high)/2);		
		if(low < high) {
			int i=0, j=0, k=low;
			// Make copies of both partitions
			int[] a = Arrays.copyOfRange(arr, low, mid+1);
			int[] b = Arrays.copyOfRange(arr, mid+1, high+1);

			int n1 = a.length;
			int n2 = b.length;
			
			// Save values to array in sorted manner
			while(i<n1 && j<n2) {
				if(a[i]<b[j]) {
					arr[k]=a[i];
					i++;
				} else {
					arr[k]=b[j];
					j++;
				}
				k++;
			}
			while(i<n1) {
				arr[k++]=a[i++];
			}
			while(j<n2) {
				arr[k++]=b[j++];
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] x = {111, 2, 3, 5, 4, 45, 76, 23, 87, 33, 506};
		MergeSort.sort(x, 0, x.length-1);
		for (int z:x) {System.out.println(z);}
	}
}
