package random;

import java.util.Arrays;

public class SearchElement {
	
	public static void main(String...args){
	
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		for (int e: array){
			int a = searchElement(array, 0, array.length-1, e);
			System.out.println(e + " : " + a);
		}
//		int a = searchElement(array, 0, array.length-1, 5);
//		System.out.println(a);
	}

	private static int searchElement(int[] array, int l, int u, int i) {
		int r =0;
		int m = (l + u)/2;
		if (i == array[m]) r = m;
		else if (i==array[l]) r=l;
		else if (i==array[u]) r=u;
		else if (array[l] < array[m]){
			if (i > array[m]){
				r = searchElement(array, m+1, u, i);
			}
			else if (i > array[l]) {
				r = searchElement(array, l, u-1, i);
			}
			else {
				r = searchElement(array, m+1, u, i);
			}
		}
		else {
			if (i < array[m]){
				r = searchElement(array, l, m-1, i);
			}
			else if (i < array[u]) {
				r = searchElement(array, m+1, u, i);
			}
			else {
				r = searchElement(array, l, m-1, i);
			}
			
		}
		
		return r;

	}
	
	

}
