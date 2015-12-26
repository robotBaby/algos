package practise;

import java.util.ArrayList;

public class DynamicPrigramming {
	
	public static void main(String...args){
		int[] a = {-1,3,5,6,-7,2,4,-38,9,12,-10,11,13};
		ArrayList<ArrayList<Integer>> longest_increasing = LongestIncreasing(a);
		System.out.println(Integer.toBinaryString((-1^4)));
		System.out.println(Integer.toBinaryString((-5)));

		
		
	}

	private static ArrayList<ArrayList<Integer>> LongestIncreasing(int[] a) {
		ArrayList<ArrayList<Integer>> longest_increasing = new ArrayList<ArrayList<Integer>>();
		int[] max_subsequence = new int[a.length];
		max_subsequence[0] = a[0];
		for (int i = 1; i < a.length; i++){
			
		}
		return longest_increasing;
	}

	private static ArrayList<Integer> MaxSum(int[] a) {
		ArrayList<Integer> maximum = new ArrayList<Integer>();
		int[] max_sum = new int[a.length];
		max_sum[0] = a[0];
		for (int j = 1; j < a.length; j++){
			int temp1 = max_sum[j-1] + a[j];
			int temp2 = a[j];
			if (temp1 >= temp2){
				max_sum[j] = temp1;
				maximum.add(a[j]);
			} else {
				max_sum[j] = temp2;
				maximum = new ArrayList<Integer>();
				maximum.add(a[j]);
			}

		}
		
		return maximum;
	}

}
