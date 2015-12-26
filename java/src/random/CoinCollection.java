package random;

public class CoinCollection {
	
	public static void main(String...args){
		System.out.println(makeChange(10, 25));
		
	}

	public static int makeChange(int n, int denom) {
		int ways = 0;
		int next_denom = 0;
		if (denom == 25) next_denom = 10;
		else if (denom == 10) next_denom = 5;
		else if (denom == 5) next_denom = 1;
		else if (denom ==1) return 1;
		int max_goes = (int) n/denom;
		
		for (int i = 0; i <=max_goes; i++){
			ways+= makeChange(n-i*denom, next_denom);
		}
	
	return ways;
	}

}
