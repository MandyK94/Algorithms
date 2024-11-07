package NeetCode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestRepeatingSubstringWithReplacement {

	
	public static int characterReplacement(String s, int k) {
    
		int res = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int l=0;
		int freq = 0;
		for(int r=0;r<s.length();r++) {
			map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
			freq=Math.max(freq, map.get(s.charAt(r)));
			
			while((r-l+1-freq)>k) {
				map.put(s.charAt(l), map.get(s.charAt(l))-1);
				l++;
			}
			res = Math.max(res, r-l+1);
		}
		
		return res;
    }
	
	public static int characterReplacementWithSet(String s, int k) {
		int res = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		for(char c:s.toCharArray()) {
			set.add(c);
		}
		
		for(char c:set) {
			int count = 0, l=0;
			for(int r=0;r<s.length();r++) {
				if(s.charAt(r)==c) {
					count++;
				}
				
				while((r-l+1-count)>k) {
					if(s.charAt(l)==c) {
						count--;
					}
					l++;
				}
				res = Math.max(res, r-l+1);
			}
		}
		
		
		
		return res;
	}
	public static void main(String[] args) {
		System.out.println(LongestRepeatingSubstringWithReplacement.characterReplacementWithSet("AAABABB", 1));
	}
}

