package NeetCode150;

import java.util.Stack;

public class ValidateParentheses {
	public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
		Stack<Character> q = new Stack<Character>();
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(' || c=='{'||c=='[') {
				System.out.println(c);
				q.add(s.charAt(i));
			} else {
				if(q.isEmpty()) return false;
				char c2 = q.pop();

				System.out.println("c: "+c+", c2 : "+c2);
				if((c2=='('&&c!=')') ||(c2=='{'&&c!='}')||(c2=='['&&c!=']')) {
					return false;
				}
			}
			
		}
		if(!q.isEmpty()) return false;
		return true;
    }
	public static void main(String[] args) {
		ValidateParentheses vp = new ValidateParentheses();
		System.out.println(vp.isValid("(("));
		
	}
}
