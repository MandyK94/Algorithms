package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdDiscluded {

	public int[] productExceptSelf(int[] nums) {
        int[] prods = new int[nums.length];
        int allProd = 1;
        List<Integer> zeroCount = new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++) {
        	if(nums[i]!=0) {
        		allProd*=nums[i];
        	} else {
        		zeroCount.add(i);
        	}
        }
        
        Arrays.fill(prods, 0);
        
        if(zeroCount.size()==0) {
        	for(int i=0;i<nums.length;i++) {
        		prods[i] = allProd/nums[i];
        	}
        } else if(zeroCount.size()==1) {
        	prods[zeroCount.get(0)] = allProd;
        }
        return prods;
    }
	
}
