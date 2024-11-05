package NeetCode150;

public class MinCostClimbingStairs {

	
	public static int cost(int[] cost) {
		int totalCost = 0;
		for(int i=cost.length-1;i>0;) {
			if(cost[i]<cost[i-1]) {
				totalCost+=cost[i];
				i--;
			} else {
				totalCost+=cost[i-1];
				i-=2;
			}
		}
		
		return totalCost;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 1, 2, 1, 1, 1};
		System.out.println(MinCostClimbingStairs.cost(arr1));
		System.out.println(MinCostClimbingStairs.cost(arr2));
	}
}
