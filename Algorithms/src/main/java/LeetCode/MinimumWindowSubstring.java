package LeetCode;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		
		if(s.length()<t.length()) {
			return "";
		}
		int l=0;
		int minLength = Integer.MAX_VALUE;
		int minIndex = -1;
		
		int[] countT = new int[255];
		int[] countS = new int[255];
		
		for(int i=0;i<t.length();i++) {
			countT[t.charAt(i)]++;
		}
		
		int stringLen = 0;
		for(int r=0;r<s.length();r++) {
			char currChar = s.charAt(r);
			countS[currChar]++;
			if(countS[currChar]>0 && countS[currChar]<=countT[currChar]) {
				stringLen++;
			}
			if(stringLen==t.length()) {
				char startChar;
				while(countS[startChar=s.charAt(l)]>countT[startChar] || countT[startChar]==0) {
					if(countS[startChar]>countT[startChar]) {
						countS[startChar]--;
					}
					l++;
				}
				int len = r-l+1;
				if(minLength>len) {
					minLength=len;
					minIndex=l;
				}
			}
		}
		
		return minIndex==-1? "" :s.substring(minIndex, minIndex+minLength);
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
	
}
