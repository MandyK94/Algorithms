package NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	
	public static List<String> generateParenthesis(int n) {
		
		List<String> list = new ArrayList<String>();
		StringBuilder stack = new StringBuilder();
		backtrack(0, 0, n, list, stack);
		return list;
	}
	
	
	private static void backtrack(int open, int close, int n, List<String> list, StringBuilder str) {
		if(open==close && open==n) {
			list.add(str.toString());
			return;
		} else if(open<n) {
			str.append('(');
			backtrack(open+1, close, n, list, str);
			str.deleteCharAt(str.length()-1);
		} 
		if(close<open) {
			str.append(')');
			backtrack(open, close+1, n, list, str);
			str.deleteCharAt(str.length()-1);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
