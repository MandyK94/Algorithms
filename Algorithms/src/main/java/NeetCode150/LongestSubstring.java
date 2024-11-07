package NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static int withoutDuplicates(String s) {
		int maxLen = 0;
		int start = 0;
		int end =0;
		
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				end = i;
				maxLen = Math.max(maxLen, end-start+1);
				System.out.println("Non duplicate: "+i+ " start "+start+ " end "+end);				
			} else {
				start = Math.max(map.get(s.charAt(i))+1, start);
				map.put(s.charAt(i), i);
				end = i;
				System.out.println("Duplicate: "+i+ " start "+start+ " end "+end);	
				maxLen = Math.max(maxLen, end-start+1);
			}
		}
		return maxLen;
	}
			
	public static void main(String[] args) {
		System.out.println(withoutDuplicates("abba"));
	}
}
