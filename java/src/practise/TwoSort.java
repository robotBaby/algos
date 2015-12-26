package practise;

import java.util.Arrays;

public class TwoSort {
	
	public static void main(String...args){
		
		int[] a = {3,4,1,9,0,2,5,7};
		int[] b = mergesort(a, 0, a.length -1);
		int[] c = quicksort(a, 0, a.length-1);
		System.out.println(Arrays.toString(c));
	}
	
	public static int[] quicksort(int[] a, int l, int u){
		int i = l;
		int j = u;
		int k = (l+u)/2;
		int p = a[k];
		while(i <= j){
			while(a[i] < p){
				i++;
			}
			while( a[j] > p){
				j--;
			}
			if (i <= j){
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
			}
		}
		if (i < u) quicksort(a, i, u);
		if (j > l) quicksort(a, l, j);
		return a;
	}
	public static int[] mergesort(int[] a, int l, int u){
		int[] b = new int[u-l +1];
		if (u==l){
			b[0] = a[u];
		} else {
			int m = (l + u)/2 ;
			int[] b1 = mergesort(a, l,m);
			int[] b2 = mergesort(a, m+1, u);
			b = merge(b1, b2);
		}
		
		return b;
	}

	public static int[] merge(int[] b1, int[] b2){
		int[] b = new int[b1.length + b2.length];
		int i = 0; 
		int j = 0;
		int k = 0;
		while(i < b1.length && j < b2.length){
			if (b1[i] <= b2[j]){
				b[k] = b1[i];
				i++;
			} else {
				b[k] = b2[j];
				j++;
			}
			k++;
		}
		
		if (i != b1.length){
			while(i < b1.length){
				b[k] = b1[i];
				i++;
				k++;
			}
		} else {
			while(j < b2.length){
				b[k] = b2[j];
				j++;
				k++;
			}
		}
		return b;
	}
}
