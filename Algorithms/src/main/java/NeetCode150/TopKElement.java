package NeetCode150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElement {

	
	public int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int x:nums) {
			int count = map.getOrDefault(x, 0);
			map.put(x, ++count);
		}
		

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			
			public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
				return (c2.getValue()-c1.getValue());
			}
		});
		
		int[] result = new int[k];
		for(Map.Entry<Integer, Integer> m : list) {
			result[k-1] = m.getKey();
			k--;
			if(k==0) {
				return result;
			}
		}
		
		return null;
    }
	
	public static void main(String[] args) {
		TopKElement t = new TopKElement();
		int[] vals = {1, 2, 2, 2, 4, 4, 4, 4, 3, 3};
		int[] res = t.topKFrequent(vals, 2);
		for(int r:res) {
			System.out.println(r);
		}
	}
	
}
