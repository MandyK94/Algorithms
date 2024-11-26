package NeetCode150;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	int time;
	private Map<Integer, Set<Integer>> followMap;
	private Map<Integer, List<Integer[]>> tweetMap;
	
	public Twitter() {
		time=0;
        followMap = new HashMap<Integer, Set<Integer>>();
        tweetMap = new HashMap<Integer, List<Integer[]>>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<Integer[]>());
        tweetMap.get(userId).add(new Integer[] {time--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>(Comparator.comparingInt(a->a[0]));
        
        followMap.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
        
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<Integer>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k, v)->{
        	v.remove(followerId);
        	return v;
        });
    }
}
