package sort;

public class QuickSort {
	
	public static void sort(int arr[], int low, int high) {
		
		if (low<high) {
			// Partition the array into two and get the pivot position
			int p = partition(arr, low, high);
			// sort each partition
			sort(arr, low, p-1);
			sort(arr, p+1, high);
		}
		
	}
	
	private static int partition(int[] arr, int low, int high) {
		// last element is the pivot
		int pivot = arr[high];
		// Keeps track of the index of last lower value
		int i = low-1;
		// go through the array
		for(int j=low;j<high;j++) {
			// if the value is lower than pivot value
			if(arr[j]<pivot) {
				i++;
				// Swap the value with the index next to the lower value
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		// swap the pivot
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		// return the index of the pivot
		return ++i;
	}
	
	public static void main(String args[]) {

		System.out.println("Quick sort");
		int arr[] = {1, 2, 5, 4, 7, 1};
		QuickSort.sort(arr, 0, arr.length-1);
		for(int x:arr) {
			System.out.println(x);
		}
	}

}
