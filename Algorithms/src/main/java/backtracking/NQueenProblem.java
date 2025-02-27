package backtracking;

import java.util.ArrayList;

public class NQueenProblem {
	
	
	public static boolean isSafe(ArrayList<Integer> board, int row, int col) {
		
		for(int i=0;i<board.size();i++) {
			int placedRow = board.get(i);
			int placedCol = i+1;
			
			if(Math.abs(placedCol-col)==Math.abs(placedRow-row)) {
				return false;
			}
		}
		return true;
	}
	
	public static void NQueenNaive(ArrayList<Integer> board, ArrayList<ArrayList<Integer>> res, 
			int n, int col, boolean[] visited) {
		
		if(col>n) {
			res.add(new ArrayList<>(board));
			return;
		}
		
		for(int row=1; row<=n; row++) {
			if(!visited[row]) {
				if(isSafe(board, row, col)) {
					visited[row] = true;
					board.add(row);
					NQueenNaive(board, res, n, col+1, visited);
					board.remove(board.size()-1);
					visited[row]=false;
				}
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> nQueenNaive(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        boolean[] visited = new boolean[n +1];
        NQueenNaive(board, res, n, 1, visited);
        return res;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res = nQueenNaive(4);
		for(ArrayList<Integer> row:res) {
			System.out.print("[");
			
			for(int i=0;i<row.size();i++) {
				System.out.print(row.get(i)+ " ");
			}
			
			System.out.println("]");
		}
	}

}
