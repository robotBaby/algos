package elementarySort;

import java.util.Arrays;
import java.util.Random;

public class ColoredBalls {

	private static int[] random = new int[10];
	

	public static void main(String[] args) {
	    Random randomGenerator = new Random();
		for (int i = 0; i < random.length; i++) {
		      int randomInt = randomGenerator.nextInt(1000);
		      int rem = randomInt % 3;
		      random[i] = rem;
		}
		
		System.out.println(Arrays.toString(random));
		
		int colorA = 0, colorB =0, colorC=0;
		int hi=random.length-1, mid=0;
		
		colorA=random[0];
		for (int lo=1; lo <= hi; lo++) {
			if(random[lo] == colorA) {
				if (mid != 0) {
					random[lo] = colorC;
					random[mid] = colorA;
					lo--;
					mid++;
				}
			}
			else {
				if (colorB == 0) {
					if (random[hi] == colorA) {
					colorB = random[lo];
					random[lo] = colorA;
					random[hi] = colorB;
					hi--;
					}
					else {
						colorB = random[hi];
						hi--;
						lo--;
					}
				}
				else if (random[lo] == colorB){
					random[lo] = random[hi];
					random[hi] = colorB;
					hi--;
					lo--;
				}

				else if (random[lo] != colorB && mid == 0) {
					if (colorC == 0) colorC = random[lo];
					mid = lo;
				}
			}
			System.out.println(Arrays.toString(random));

		}

	}

	

}
