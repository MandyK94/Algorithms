package NeetCode150;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private class CacheData {
		int[] data;
		CacheData prev;
		CacheData next;
		
		public CacheData(int[] data) {
			this.data = data;
			prev = null;
			next=null;
		}
	}
	
	private int capacity;
	private Map<Integer, CacheData> cache;
	CacheData leastPtr;
    CacheData mostPtr;
    
	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, CacheData>();
        leastPtr = new CacheData(null);
        mostPtr = new CacheData(null);
        leastPtr.prev = mostPtr;
        mostPtr.next = leastPtr;
    }
    
	private void remove(CacheData node) {
		CacheData prev = node.prev;
		CacheData next = node.next;
		prev.next=next;
		next.prev = prev;
	}
	
	private void insert(CacheData prev, CacheData next, CacheData node) {
		prev.next = node;
		node.next = next;
		next.prev = node;
		node.prev = prev;
	}
	
    public int get(int key) {
    	if(!cache.containsKey(key)) {
    		return -1;
    	}
    	CacheData data = cache.get(key);
    	remove(data);
    	insert(mostPtr, mostPtr.next, data);
    	
        return data.data[1];
    }
    
    public void put(int key, int value) {
    	CacheData data =null;
    	if(cache.containsKey(key)) {
    		data = cache.get(key);
        	data.data[1] = value;
        	
        	remove(data);
        } else {
        	data = new CacheData(new int[] {key, value});
        	cache.put(key, data);
        }
    	insert(mostPtr, mostPtr.next, data);
    	
    	
    	if(cache.size()>capacity) {
    		cache.remove(leastPtr.prev.data[0]);
    		remove(leastPtr.prev);
    	}
    }
	public static void main(String[] args) {
		/*LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 10);  // cache: {1=10}
		System.out.println(lRUCache.get(1)); // return 10
		lRUCache.put(2, 20);  // cache: {1=10, 2=20}
		lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
		System.out.println(lRUCache.get(2));      // returns 20 
		System.out.println(lRUCache.get(1));	  // return -1 (not found)
		*/
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); //{1=1}
		lRUCache.put(2, 2); //{1:1, 2=2}
		System.out.println(lRUCache.get(1)); // 1
		lRUCache.put(3, 3); //{1:1, 3:3}
		System.out.println(lRUCache.get(2)); // -1    
		lRUCache.put(4, 4); //{3:3, 4:4}
		System.out.println(lRUCache.get(1)); // -1
		System.out.println(lRUCache.get(3)); // 3
		System.out.println(lRUCache.get(4)); // 4
	}
}
