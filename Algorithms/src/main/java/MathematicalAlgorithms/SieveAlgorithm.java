package MathematicalAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class SieveAlgorithm {

	
	public static List<Integer> primeList(int N){
		
		boolean[] isPrime = new boolean[N];
		List<Integer> prime = new ArrayList<Integer>();
		int[] spf = new int[N];
		
		
		for(int i = 0;i<N;i++) {
			isPrime[i] = true;
			spf[i] = 2;
		}
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2;i<N;i++) {
			if(isPrime[i]) {
				prime.add(i);
				spf[i]=i;
			}
			for(int j=0;
					j<prime.size() && 
					i*prime.get(j)<N && 
					prime.get(j)<=spf[i];
					j++) {
				
				isPrime[i*prime.get(j)] = false;
				spf[i*prime.get(j)] = prime.get(j);
			}
		}
		
		
		return prime;
	}
	
	
	public static void main(String[] args) {
		System.out.println(SieveAlgorithm.primeList(25));
	}
}
