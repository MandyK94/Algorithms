package backtracking;

public class KnightsTour {

	private static int N = 5;
	
	
	// check id x and y are valid indexes
	static boolean isValid(int x, int y, int[][] sol) {
		if(x>=0 && x<N && y>=0 && y<N && sol[x][y]==0) {
			return true;
		}
		return false;
	}
	
	static void solution() {
		
		int[][] sol = new int[8][8];
		
		// all the valid moves
		int xMove[] = {1, 1, 2, 2, -1, -1, -2, -2};
		int yMove[] = {2, -2, 1, -1, 2, -2, -1, 1};
		
		//first move
		sol[0][0] = 1;
		
		
		// if the return value is false then there is no valid solution found by the function
		if(!solutionUtil(0, 0, 2, sol, xMove, yMove)) {
			System.out.println("solution doesn't exist");
		}
		
		// otherwise a solution is found and print
		printSol(sol);
		
	}
	
	
	static void printSol(int[][] sol) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	static boolean solutionUtil(int x, int y, int move, int[][] sol, int[] xMoves, int[] yMoves) {
		
		//if the move reaches over N then solution is already found
		if(move > N*N) {
			return true;
		}
		int nextX=0, nextY=0;
		for(int i=0; i<8;i++) {
			nextX = x+xMoves[i];
			nextY = y+yMoves[i];
			if(isValid(nextX, nextY, sol)) {
				sol[nextX][nextY]=move;
				System.out.flush();
				printSol(sol);
				if(solutionUtil(nextX, nextY, move+1, sol, xMoves, yMoves)) {
					return true;
				}
				else {
					sol[nextX][nextY]=0;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		KnightsTour.solution();
		
		
	}	
	
}
