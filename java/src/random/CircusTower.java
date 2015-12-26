package random;

import java.util.Arrays;

public class CircusTower {
	
	public static void main(String...args){
		int[][] people = {{60, 100}, {70, 150}, {56, 90}, {75, 190}, {60, 95}, {68,110}};
		int[][] sorted = sort(people);
		int tower_height = count(sorted);
		System.out.println(tower_height);
	}

	private static int count(int[][] sorted) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int[][] sort(int[][] people) {
		int[] height = new int[people.length];
		int[] weight = new int[people.length];
		for (int i = 0; i < people.length; i++){
			height[i] = people[i][0];
		}

		System.out.println(Arrays.toString(height));
		return null;
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
