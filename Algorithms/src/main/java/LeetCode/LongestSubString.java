package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
	
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {
			return 0;
		}
		int count = 1;
		
		int lPtr = 0;
		int rPtr = 1;
		
		int currCount = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		map.put(s.charAt(0), 0);
		
		while(lPtr<s.length() && rPtr<s.length()& lPtr<=rPtr) {
			if(map.containsKey(s.charAt(rPtr))) {
				int nextIndex = map.get(s.charAt(rPtr));
				while(lPtr<=nextIndex) {
					map.remove(s.charAt(lPtr));
					lPtr++;
				}
				lPtr = nextIndex+1;
				map.put(s.charAt(rPtr), rPtr);
				
			} else {
				map.put(s.charAt(rPtr), rPtr);
				
			}
			rPtr++;
			currCount = rPtr - lPtr;
			count= Math.max(count, currCount);
		}
		
		return count;
	}

	
	public static void main(String[] args) {
		LongestSubString l = new LongestSubString();
		System.out.println(l.lengthOfLongestSubstring("abbbab"));
	}
}
