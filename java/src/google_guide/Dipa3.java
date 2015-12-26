package google_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Dipa3 {

	private static Random rand = new Random();
	public static void main(String... args) {
		
		///////////////////////////////////////////////////////////////////////
		int[] a = new int[4];
		int[] b = new int[25];
		for (int i = 0 ; i < a.length; i++) a[i] = Math.abs(rand.nextInt() % 4) ;
		for (int i = 0 ; i < b.length; i++) b[i] = Math.abs(rand.nextInt() % 25) + 5 ;
		int[] sort_a = sort(a);
		int[] sort_b = sort(b);
		int[] a_b = mergeArrays( sort_a, sort_b);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(sort_a));
//		System.out.println(Arrays.toString(sort_b));
//		System.out.println(Arrays.toString(a_b));

		///////////////////////////////////////////////////////////////////////
		ArrayList<ArrayList<Integer>> coordinates = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 30; i++) {
			ArrayList<Integer> thiscoordinate = new ArrayList<Integer>();
			for (int j = 0; j < 3; j++){
				int value = Math.abs(rand.nextInt()) % 30;
				thiscoordinate.add(value);
			}
			coordinates.add(thiscoordinate);
		}
		System.out.println(coordinates);
		ArrayList<Object> returnList = computeDistance(coordinates);
		int[] distanceMatrix = (int[]) returnList.get(0);
		HashMap<Integer, Integer> stars = (HashMap<Integer, Integer>) returnList.get(1);
		System.out.println(Arrays.toString(distanceMatrix));
		distanceMatrix = sort(distanceMatrix);
		System.out.println(Arrays.toString(distanceMatrix));

	}
	
	private static ArrayList<Object> computeDistance(ArrayList<ArrayList<Integer>> coordinates){		
		ArrayList<Object> returnList = new ArrayList<Object>();
		ArrayList<Integer> distM = new ArrayList<Integer>(); 
		ArrayList<Integer> star1 = new ArrayList<Integer>(); 
		ArrayList<Integer> star2 = new ArrayList<Integer>(); 

		for (int i = 0; i < coordinates.size(); i++) {
			ArrayList<Integer> stari = coordinates.get(i);
			for (int j = i; j < coordinates.size(); j++){
				ArrayList<Integer> starj = coordinates.get(j);
				int sqDist = 0;
				for (int k = 0; k < 3; k++){
					sqDist += Math.pow((stari.get(k) - starj.get(k)), 2); 
				}
				int dist = (int) Math.sqrt(sqDist);
				distM.add(dist);
				star1.add(i);
				star2.add(j);
			}
		}
		int[] distanceMatrix = new int[distM.size()];
		HashMap<Integer, Integer> stars = new HashMap();
		for (int i = 0; i< distanceMatrix.length; i++) {
			distanceMatrix[i] = distM.get(i);
			stars.put(star1.get(i), star2.get(i));
		}
		returnList.add(distanceMatrix);
		returnList.add(stars);
		return returnList;
	}
	private static int[] sort(int[] a) {
		int n = a.length/2;
		int[] a1 = new int[n];
		int[] a2 = new int[a.length - n];
		final int[] temp1 = new int[n];
		System.arraycopy(a, 0, temp1, 0, n);
		final int[] temp2 = new int[a.length - n];
		System.arraycopy(a, n, temp2, 0, a.length - n);
		if (temp1.length > 1) a1 = sort(temp1);
		else a1 = temp1;
		if (temp2.length > 1) a2 = sort(temp2);
		else a2 = temp2;
		int[] returnArray = mergeArrays(a1, a2);
		
		return returnArray;
		
	}
	private static int[] mergeArrays(int[] a, int[] b) {
		ArrayList<Integer> a_b = new ArrayList<Integer>();
		int p1 = 0; 
		int p2 = 0;
		for (int i = 0; p1 < a.length && p2 < b.length; i++){
			if (a[p1] < b[p2]) {
				a_b.add(a[p1]); 
				p1++;
			}
			else if (b[p2] < a[p1]) {
				a_b.add(b[p2]); 
				p2++;
				}
			else if (a[p1]==b[p2]) {
				a_b.add(a[p1]); 
				a_b.add(b[p2]);
				p1++; 
				p2++;
			}
		}
		if (p1 < a.length) {
			for (int p = p1; p < a.length; p++) a_b.add(a[p]);
		}
		else if (p2 < b.length) {
			for (int p = p2; p < b.length; p++) a_b.add(b[p]);
		}
		int[] ab = new int[a_b.size()];
		for (int i = 0; i < a_b.size(); i++){
			ab[i] = a_b.get(i);
		}
		return ab;
	}
}
