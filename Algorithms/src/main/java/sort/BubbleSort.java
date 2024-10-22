package sort;

public class BubbleSort {
	
	
	public static int[] sort(int arr[]) {
		//size of the array
		int n = arr.length;
		//System.out.println(n);
		int i, j, temp;
		boolean swapped;
		for (i=0; i<n-1;i++) {
			swapped = false;
			for (j=0;j<n-i-1;j++) {
				
				if(arr[j]>arr[j+1]) {
					System.out.println("i:"+i+", j:"+j);
					temp =  arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			// To come out of the loop if the array is already sorted
			if(!swapped) {
				System.out.println("Break");
				break;
			}
		}
		for(int k:arr) {
			System.out.println(k);
		}
		
		return arr;
	}
	
	
	public static void recursiveSort(int arr[], int n) {
		if(n==1) {
			return;
		}
		
		boolean swapped = false;
		for(int i=0;i<n-1;i++) {
			int temp;
			if(arr[i]>arr[i+1]) {
				temp = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				swapped = true;
			}
		}
		if(!swapped) {
			for(int x:arr) {
			System.out.println(x);}
			return;
		} 
		
		recursiveSort(arr, n-1);
	}
	
	public static void main(String args[]){
		
		int arr[] = {1, 2, 5, 4, 7, 1};
		BubbleSort.recursiveSort(arr, arr.length);
		
	}
}
