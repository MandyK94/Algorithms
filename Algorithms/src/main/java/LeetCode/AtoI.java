package LeetCode;

public class AtoI {
	
	public int myAtoi(String s) {
		
		//s = s.replace(" ", "");
		s=s.trim();
		if(s.length()==0) {
			return 0;
		}
		boolean neg = s.charAt(0)=='-'?true:false;
		boolean pos=s.charAt(0)=='+'?true:false;
		
		if(neg||pos) {
			s=s.substring(1);
		}

		int x=0;
		//System.out.println(s);
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				break;
			}//System.out.println(Integer.valueOf(s.charAt(i)+""));
			//if(x>Integer.MAX_VALUE/10) {	
			//	return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
			//}
			x=x*10;
			x=x+Integer.valueOf(s.charAt(i)+"");
			if(x<0||x>Integer.MAX_VALUE/10) {
				return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
			
			//System.out.println(x);
		}
		return neg?-x:x; 
	}

	
	public static void main(String[] args) {
		AtoI a = new AtoI();
		System.out.println(a.myAtoi("91283472332"));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
