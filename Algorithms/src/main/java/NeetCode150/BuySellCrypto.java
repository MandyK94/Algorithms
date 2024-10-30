package NeetCode150;

public class BuySellCrypto {
	
	public int maxProfit(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
        	if(prices[i]>max) {
        		max = prices[i];
        		if((max-min)>profit)
        			profit = max-min;
        	}
        	if(prices[i]<min) {
        		min=prices[i];
        		max=min;
        	}
        }
        return profit;
    }

	
	
	public static void main(String[] args) {
		BuySellCrypto bs = new BuySellCrypto();
		
		int[] p = {10,8,7,5,2};
		System.out.println(bs.maxProfit(p));
	}
}
