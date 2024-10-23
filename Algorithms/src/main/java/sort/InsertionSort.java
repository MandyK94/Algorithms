package sort;

public class InsertionSort {

	public static int[] sort(int[] arr) {
		
		for(int i=1;i<arr.length;i++ ) {
			int key = arr[i];
			// from back to front, move the elements to back if greater than key
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>key) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
				arr[j]=key;
			}
			
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {23, 1, 5, 2};
		arr= InsertionSort.sort(arr);
		for(int x:arr) {
			System.out.println(x);
		}
	}
	
}
