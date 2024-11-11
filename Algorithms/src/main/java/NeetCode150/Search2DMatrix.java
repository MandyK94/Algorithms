package NeetCode150;

public class Search2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int ROWS = matrix.length;
		int COLS = matrix[0].length;
		int r=ROWS*COLS-1, l=0;
		
		while(l<=r) {
			System.out.println(" l "+l+" r "+r);
			int mid = (l+r)/2;
			int i, j;
			j=mid%COLS;
			i=mid/COLS;
			if(target==matrix[i][j]) {
				return true;
			}
			if(target<matrix[i][j]) {
				r=mid-1;
			} else {
				l=mid+1;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,4,8}, {10,11,12,13}, {14,20,30,40}, {50, 60, 61, 70}};
		System.out.println(searchMatrix(matrix, 9));
	}
	
}
