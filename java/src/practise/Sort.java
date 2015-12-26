package practise;

import java.util.Arrays;

public class Sort {
	
	public static void main(String...args){
		int[] a = {2,4,5,1,6,3,7,0,8,2,7,9,9,3,6};
		int[] b = mergesort(a, 0, a.length-1);
		int[] c = quicksort(a, 0, a.length -1);
		System.out.println(Arrays.toString(c));
		
		
	}

	private static int[] quicksort(int[] a, int l, int u) {
		int i = l;
		int j = u;
		int k = (l+u)/2;
		int pivot = a[k];
		while(i <=j){
			while(a[i] < pivot){
				i++;
			}
			while(a[j] > pivot){
				j--;
			}
			if (i <= j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		
		if(i < u)  quicksort(a, i, u);
		if (j > l) quicksort(a, l, j);

		return a;
	}

	private static int[] mergesort(int[] a, int l, int u) {
		int[] sorted = new int[u-l + 1];
		if (u == l+1){
			if (a[l] > a[u]) {
				sorted[0] = a[u];
				sorted[1] = a[l];
			} else {
				sorted[0] = a[l];
				sorted[1] = a[u];
			}
			
		} else if (u==l){
			sorted[0] = a[u];
		} else {
		int m = (l+u)/2;
		int[] s1 = mergesort(a, l, m);
		int[] s2 = mergesort(a, m+1, u);
		sorted = merge(s1, s2);
		}
		return sorted;
	}
	
	private static void quickSort(int[] array, int lowerIndex, int higherIndex) {
	int i = lowerIndex;
    int j = higherIndex;
    // calculate pivot number, I am taking pivot as middle index number
    int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
    // Divide into two arrays
    while (i <= j) {
        /**
         * In each iteration, we will identify a number from left side which
         * is greater then the pivot value, and also we will identify a number
         * from right side which is less then the pivot value. Once the search
         * is done, then we exchange both numbers.
         */
        while (array[i] < pivot) {
            i++;
        }
        while (array[j] > pivot) {
            j--;
        }
        if (i <= j) {
            exchangeNumbers(array, i, j);
            //move index to next position on both sides
            i++;
            j--;
        }
    }
    // call quickSort() method recursively
    if (lowerIndex < j)
        quickSort(array, lowerIndex, j);
    if (i < higherIndex)
        quickSort(array, i, higherIndex);
}

private static void exchangeNumbers(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

	private static int[] merge(int[] s1, int[] s2) {
		int i = 0;
		int j = 0;
		int[] sorted = new int[s1.length + s2.length];
		int c = 0;
		while(c < sorted.length && i < s1.length && j < s2.length){
			if (s1[i] < s2[j]){
				sorted[c] = s1[i];
				i++;
			} else {
				sorted[c] = s2[j];
				j++;
			}
			c++;
		}
		if (c != sorted.length){
			if ( i != s1.length){
				while(c < sorted.length){
					sorted[c] = s1[i];
					i++;
					c++;
				}
			} else if (j != s2.length){
				while(c < sorted.length){
					sorted[c] = s2[j];
					j++;
					c++;
				}
			}
		}
		return sorted;
	}

}
