package NeetCode150;

import java.util.Stack;

public class MinStack {
	
	int min;
	Stack<Integer> stack;
	
	public MinStack() {
        stack  = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
        	stack.push(0);
        	min = val;
        } else {
        	stack.push(val-min);
        	if(min>val) {
        		min=val;
        	}
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val<0) {
        	min = min-val;
        }
    }
    
    public int top() {
    	long top = stack.peek();
        if(top >0){return (int) (top+min);}
        else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(1);
    	minStack.push(2);
    	minStack.push(0);
    	System.out.println(minStack.getMin()); // return 0
    	minStack.pop();
    	System.out.println(minStack.top());    // return 2
    	System.out.println(minStack.getMin()); // return 1
	}
}
