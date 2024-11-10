package NeetCode150;

import java.util.Stack;

public class DailyTemperatures {

	public static int[] dailyTemperatures(int[] temperatures) {
		
		int[] res = new int[temperatures.length];
		
		Stack<Integer[]> stack  = new Stack<Integer[]>();
		
		stack.push(new Integer[]{temperatures[0], 1});
		for(int i=1;i<temperatures.length;i++) {
			int temp = temperatures[i];
			Integer[] top = stack.peek();
			if(top[0]>=temp) {
				stack.push(new Integer[] {temp, i+1});
			} else {
				res[top[1]-1] = i-top[1]+1;
				while(!stack.isEmpty() && stack.peek()[0]<temp) {
					top = stack.pop();
					res[top[1]-1] = i-top[1]+1;
				}
				stack.push(new Integer[] {temp, i+1});
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] temp = new int[] {30,38,30,36,35,40,28};
		int[] res = dailyTemperatures(temp);
		for(int x:res) {
			System.out.print(x+" ");
		}
	}
	
}
