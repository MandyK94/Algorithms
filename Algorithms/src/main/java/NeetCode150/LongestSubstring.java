package NeetCode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

	
	public static int lengthOfLongestSubstring(String s) {
		int len=0;
		int l=0;
		Set<Character> set = new HashSet<Character>();
		for(int r= 0;r<s.length();r++) {
			
			while(set.contains(s.charAt(r))) {
				set.remove(s.charAt(l));
				l++;
			}
			
			set.add(s.charAt(r));
			len = Math.max(len, r-l+1);
		}
		
		
		return len;
	}
	
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
		System.out.println(lengthOfLongestSubstring("abba"));
	}
}
