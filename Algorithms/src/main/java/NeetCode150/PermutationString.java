package NeetCode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationString {
	
	public static boolean checkInclusion(String s1, String s2) {
        		
        //Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:s1.toCharArray()) {
        	//set.add(c);
        	map.put(c, map.getOrDefault(c, 0)+1);
        }
        int l=0;
        int count=0;
        for(int r=0;r<s2.length();) {
        	char c = s2.charAt(r);
        	System.out.println("character "+ c);
        	
        	if(map.getOrDefault(c, 0)>0) {
        		System.out.println("charater in set "+c);
        		count++;
        		r++;
        		//set.remove(c);
        		map.put(c, map.get(c)-1);
        	} else {
    			System.out.println("charater not in set "+c);
    			//set.add(s2.charAt(l));
    			map.put(s2.charAt(l), map.getOrDefault(s2.charAt(l), 0)+1);
    			l++;
    			count--;
        	}
        	
        	if(count==s1.length()) {
        		return true;
        	}
        }
        
		return false;
    }
	
	public static void main(String[] args) {
		boolean b = checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine");
		System.out.println(b);
	}
}
