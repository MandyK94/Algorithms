package NeetCode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

	
	private Map<String, List<Pair<Integer, String>>> map;
	
	public TimeMap() {
        this.map = new HashMap<String, List<Pair<Integer,String>>>();
    }
    
    public void set(String key, String value, int timestamp) {
    	List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<TimeMap.Pair<Integer,String>>());
    	list.add(new Pair<Integer, String>(timestamp, value));
    	map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
    	List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<TimeMap.Pair<Integer,String>>());
    	int l=0,r=list.size()-1;
    	String res = "";
    	
        System.out.println(r);
        while(l<=r) {
        	int mid=l+(r-l)/2;
        	if(list.get(mid).getTimestamp()<=timestamp) { 
        		res = list.get(mid).getValue();
        		l=mid+1;
        	} else {
        		r=mid-1;
        	}
        }
        return res;
    }
    
    private static class Pair<K, V>{
    	private final K timestamp;
    	private final V value;
    	public Pair(K timestamp, V value) {
    		this.timestamp=timestamp;
    		this.value = value;
    	}
    	
    	public K getTimestamp() {
    		return this.timestamp;
    	}
    	
    	public V getValue() {
    		return this.value;
    	}
    	
    }
    
    
    
    public static void main(String[] args) {
		//[ "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
    	
    	TimeMap tm = new TimeMap();
    	tm.set("alice", "happy", 1);
    	System.out.println(tm.get("alice", 1));
    	System.out.println(tm.get("alice", 2));
    	tm.set("alice", "sad", 3);
    	System.out.println(tm.get("alice", 3));
    	
    	
    	
	}
    
}
