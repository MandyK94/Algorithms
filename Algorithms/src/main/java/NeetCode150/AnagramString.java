package NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class AnagramString {

	
	public boolean isAnagram(String s, String t) {

		if(s.length()!=t.length()) {
			return false;
		} else {
			Map<Character, Integer> map1 = new HashMap<>();
			Map<Character, Integer> map2 = new HashMap<>();
			
			for(int i=0;i<s.length();i++) {
				char c1 = s.charAt(i);
				char c2 = t.charAt(i);
				
				if(map1.get(c1)==null) {
					map1.put(c1, 1);
				} else {
					map1.put(c1, 1+map1.get(c1));
				}
				if(map2.get(c2)==null) {
					map2.put(c2, 1);
				} else {
					map2.put(c2, 1+map2.get(c2));
				}
			}
			
			for(Map.Entry<Character, Integer> e:map1.entrySet()) {
				if(e.getValue()!=map2.get(e.getKey())) {
					return false;
				}
			}
			
		}
		
		return true;
		
    }
	
	public static void main(String[] args) {
		AnagramString a = new AnagramString();
		String s = "racecar";
		String t= "carace";
		System.out.println(a.isAnagram(s, t));
	}
	
	
	
	
}
