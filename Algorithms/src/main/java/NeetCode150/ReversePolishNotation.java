package NeetCode150;

import java.util.Stack;

public class ReversePolishNotation {
	
	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<Integer>();
		Integer val1, val2;
		for(int i = 0;i<tokens.length;i++) {
			String t = tokens[i];
			switch (t) {
			case "+": {
				stack.push(stack.pop()+stack.pop());
				break;
			}
			case "-": {
				val1 = stack.pop();
				val2 = stack.pop();
				val1=val2-val1;
				stack.push(val1);
				break;
			}
			case "*": {
				stack.push(stack.pop()*stack.pop());
				break;
			}
			case "/": {
				val1 = (Integer)stack.pop();
				val2 = (Integer)stack.pop();
				val1=val2/val1;
				stack.push(val1);
				break;
			}
			default:
				stack.push(Integer.parseInt(t));
			}
			
		}
		return stack.pop();
    }
	
	public static void main(String[] args) {
		String[] s = {"1","2","+","3","*","4","-"};
		System.out.println(evalRPN(s));
	}
	
}
