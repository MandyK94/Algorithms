package LeetCode;

public class AtoI {
	
	
	public int myAtoi(String s) {
	
		s = s.trim();
		if(s.length()==0) {
			return 0;
		}
		
		boolean neg = s.charAt(0)=='-'?true:false;
		boolean pos = s.charAt(0)=='+'?true:false;
		
		if(neg||pos) {
			s = s.substring(1);
		}
		long x = 0;
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				break;
			}
			//System.out.println(Long.valueOf(s.charAt(i)));
			x*=10;
			x+=Long.valueOf(s.charAt(i)+"");
			//System.out.println(x);
			if(x!=0) {
			if(neg && x>-(Integer.MIN_VALUE+1)) {
				return Integer.MIN_VALUE;
			} else if(!neg && x>=Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}}
		}
		return neg?(int)-x:(int)x;
	}
	
	public int myAtoi1(String s) {
		
		s=s.trim();
		if(s.length()==0) {
			return 0;
		}
		boolean neg=s.charAt(0)=='-'?true:false;
		boolean pos=s.charAt(0)=='+'?true:false;
		
		if(neg||pos) {
			s=s.substring(1);
		}

		int x=0;
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				break;
			}
			x=x*10;
			x=x+Integer.valueOf(s.charAt(i)+"");
			if(x<0) {
				return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
			if (x>Integer.MAX_VALUE/10) {
				if(x<Integer.MAX_VALUE && i+1<s.length()) {
					int temp =x*10;
					temp=temp+Integer.valueOf(s.charAt(i+1)+"");
					System.out.println(temp);
					if(temp<0 || temp<x) {
						return neg?Integer.MIN_VALUE:Integer.MAX_VALUE; 
					}
				}
				return neg?-x:x;
				//return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
		}
		return neg?-x:x; 
	}

	
	public static void main(String[] args) {
		AtoI a = new AtoI();
		System.out.println(1);
		System.out.println(a.myAtoi("2147483646"));
		System.out.println(a.myAtoi("2147483646") == 2147483646);
		System.out.println(2);
		System.out.println(a.myAtoi("-91283472332") == -2147483648);
		System.out.println(3);
		System.out.println(a.myAtoi("2147483648")== 2147483647);
		System.out.println(4);
		System.out.println(a.myAtoi("21474836460")== 2147483647);
		System.out.println(5);
		System.out.println(a.myAtoi("-6147483648")== -2147483648);
		System.out.println(6);
		System.out.println(a.myAtoi("   -042"));
		System.out.println(a.myAtoi("   -042")== -42);
		
		
		//System.out.println("Min val: "+Integer.MIN_VALUE);
		//System.out.println("Max val:  "+Integer.MAX_VALUE);
	}
}
