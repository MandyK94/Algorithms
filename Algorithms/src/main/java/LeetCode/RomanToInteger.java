package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {

	public int romanToInt(String s) {
        
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int num = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<s.length();i++) {
			System.out.println("index "+i);
			if(stack.isEmpty()) {
				System.out.println("Empty index "+i);
				stack.push(map.get(s.charAt(i)));
				continue;
			}
			
			int cur = map.get(s.charAt(i));
			System.out.println("Number "+cur);
			if(cur>stack.peek()) {
				cur = cur - stack.pop();
			}
			stack.push(cur);
		}
		while(!stack.isEmpty()) {
			num+=stack.pop();
		}
		return num;
    }
	
	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("III"));
	}
}
