package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnagramGroups {
	public List<List<String>> groupAnagrams(String[] strs) {
	
		Map<String, List<String>> map = new HashMap<>();
		for(String s:strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sortedString = new String(c);
			List<String> l = map.getOrDefault(sortedString, new ArrayList<String>());
			l.add(s);
			map.put(sortedString, l);
			
		}
		
		return new ArrayList<>(map.values());
    }
	
	public static void main(String[] args) {
		AnagramGroups ag = new AnagramGroups();
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		List<List<String>> l = ag.groupAnagrams(strs);
		System.out.println(l);

	}
}