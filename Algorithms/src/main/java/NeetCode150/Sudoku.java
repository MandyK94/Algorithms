package NeetCode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sudoku {
	
public boolean isValidSudoku(String[][] board) {
     
		Map<Integer, Set<Character>> rows = new HashMap<Integer, Set<Character>>();
		Map<Integer, Set<Character>> cols = new HashMap<Integer, Set<Character>>();
		Map<Integer, Set<Character>> squares = new HashMap<Integer, Set<Character>>();
		
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Character cell = board[i][j].charAt(0);
				if(cell=='.') {
					continue;
				}
				
				if(rows.getOrDefault(i, new HashSet<Character>()).contains(cell) ||
						cols.getOrDefault(j, new HashSet<Character>()).contains(cell) ||
						squares.getOrDefault((i/3)*3+j/3, new HashSet<Character>()).contains(cell) ) {
					return false;
					
				}
				
				Set<Character> s = rows.getOrDefault(i, new HashSet<Character>());
				s.add(cell);
				rows.put(i, s);
				s = cols.getOrDefault(j, new HashSet<Character>());
				s.add(cell);
				cols.put(j, s);
				s = squares.getOrDefault((i/3)*3+j/3, new HashSet<Character>());
				s.add(cell);
				squares.put((i/3)*3+j/3, s);
			}
		}

		return true;
    }



	public static void main(String[] args) {
		String[][] board={{"1","2",".",".","3",".",".",".","."},{"4",".",".","5",".",".",".",".","."},
				{".","9","8",".",".",".",".",".","3"},{"5",".",".",".","6",".",".",".","4"},
				{".",".",".","8",".","3",".",".","5"},{"7",".",".",".","2",".",".",".","6"},
				{".",".",".",".",".",".","2",".","."},{".",".",".","4","1","9",".",".","8"},
				{".",".",".",".","8",".",".","7","9"}};
		Sudoku s = new Sudoku();
		System.out.println(s.isValidSudoku(board));
		
	}

}
