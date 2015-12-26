package random;

import java.util.Arrays;

public class MergeArrays {
	

	public static void main(String...args){
		int[] a = {1,2,4,6,7,8,11,12,13,0,0,0,0,0};
		int[] b= {1,3,4,6,12};
		int[] c = mergeSort(a, b);
		System.out.println(Arrays.toString(c));
	}

	private static int[] mergeSort(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int l = a.length - b.length;
		int k = j;
		while(j < b.length){
			if (b[j] >= a[i] && b[j] < a[l-1]){
				i++;
			}
			else {
				a[l] = i;
				j++;
				l++;
			}
			
		}
		l -= b.length;
		while(l < a.length){
			int stop = a[l] + k;
			for (int m = l; m > stop; m-- ){
				a[m] = a[m-1];
			}
			a[stop] = b[k];
				k++;
				l++;
		}
		return a;
	}

	private static void swap(int[] a, int[] b, int i, int j, int k) {
		a[k] = a[i];
		a[i] = b[j];
	}
}
