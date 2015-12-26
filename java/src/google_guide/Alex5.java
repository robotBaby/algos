package google_guide;

import java.util.ArrayList;
import java.util.Arrays;

public class Alex5 {
	
	public static void main(String...strings){
		int a[] = {2,4,6,8,2,5,7,9,1,5,8};
		int x= 6;
		ArrayList<String> sumNumbers = new ArrayList<String>();
		int a_comp[] = createComp(a, x);
		for (int i = 0; i < a.length; i++){
			for (int j =i; j < a_comp.length; j++){
				if (a[i] == a_comp[j]) sumNumbers.add("(" + i + "," + j + ")");
			}
		}
//		System.out.println(sumNumbers);
		
		Arrays.sort(a);
//		int b[] = {1,2,2,4,5,5,6,7,8,8,9};
		ArrayList<String> threeNumbers = threenum(a, 8);
		System.out.println(threeNumbers);
	}

	private static ArrayList<String> threenum(int[] b, int x) {
		ArrayList<String> threenum = new ArrayList<String>();
		int i = 0;
		int j = b.length -1;
		int k = j;
		
		while(k > i){
			if (b[i] + b[j] + b[k] == x) {
				threenum.add("(" + i + "," + k + "," + j + ")"); 
				k--;
			}
			else if(b[i] + b[j] + b[k] > x) k--;
			else if(b[i] + b[j] + b[k] < x) i++;
			if (k == i) {
				j--;
				k = j;
			}
		}
		return threenum;
	}

	private static int[] createComp(int[] a, int x) {
		int[] a_comp = new int[a.length];
		for (int i = 0; i < a.length; i++) a_comp[i] = x - a[i];
		return a_comp;
	}

}
