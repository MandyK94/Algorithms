package NeetCode150;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
	
	public static int carFleet(int target, int[] position, int[] speed) {
		Double[][] time = new Double[position.length][2];
		
		for(int i=0;i<position.length;i++) {
			time[i][0]=(double)(target-position[i])/speed[i];
			time[i][1] = (double)position[i];
		}
		Arrays.sort(time, (a, b) -> (int) (b[1]-a[1]));
		Stack<Double> stack = new Stack<Double>();
		stack.push(0.0);
		for(int i=0;i<time.length;i++){
			System.out.println("stack value "+stack.peek() + " val " + time[i][0]);

			if( time[i][0]>stack.peek()) {
				stack.push(time[i][0]);
			} 
		}
		return stack.size()-1;
	}
	
	public static void main(String[] args) {
		System.out.println(carFleet(10, new int[] {1,4}, new int[] {3,2}));
	}
	
}
