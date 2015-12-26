package google_guide;

import java.util.ArrayList;


public class Alex4 {
	
	public static void main(String...strings){
		int a = findNextPrime(30);
		System.out.println(a);
		// n^3 memory access;
	}

	private static int findNextPrime(int x) {
		int primeAfter = 0;
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		buildPrimeList(x, primeList);
		int i = x+1;
		boolean foundPrimeAfter = false;
		while(!foundPrimeAfter){
			int j = 0;
			boolean stop = false;
			while(!stop && j < primeList.size()){
				if (i % primeList.get(j++) == 0) stop = true;
			}
			if (j == primeList.size()) {
				foundPrimeAfter = true;
				primeAfter = i;
			}
			i++;
		}
		
		return primeAfter;
	}

	private static void buildPrimeList(int x,
			ArrayList<Integer> primeList) {
		int i = 2;
		while(i <=x){
				int j = 0;
				boolean stop = false;
				while(!stop && j < primeList.size()){
					if (i % primeList.get(j++) == 0) stop = true;
				}
				if (j == primeList.size()) {
					primeList.add(i);
					i++;
				}
				i++;
		}
	}
}

