package interviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class ArraysAndStrings {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
//		System.out.println(isUniqueChars("acbb"));
//		System.out.println("aa  bb" + " " + removeSpaces("aa   bb"));
//		Random rand = new Random();
//		int[][] a = new int[3][3];
//		for (int i = 0; i < a.length ; i++) {
//			for (int j = 0; j < a[i].length; j++) {
//				a[i][j] = Math.abs(rand.nextInt() % 10);
//			}
//		}
//		System.out.println(Arrays.deepToString(a));
//		a = rotate(a);
//		System.out.println(Arrays.deepToString(a));
//		
//		LinkedList list = new LinkedList();
//		list.add(2);
//		list.add("abc");
//		list.add(2.33);
//		System.out.println(deleteNode(list, 2));

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(3); a.add(1); a.add(5); a.add(6);
		b.add(5); b.add(9); b.add(2);
		System.out.println(reverseAdd(a,b));

		
	}
	
	
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
		int val = str.charAt(i) - 'a';
		if ((checker & (1 << val)) > 0) return false;
		checker |= (1 << val);
		 }
		return true;
	}
	public static String reverseString(String str){
		String reverse = "";
		for (int i = str.length() -2; i > -1; i--) {
			reverse += str.charAt(i);
			
		}
		return reverse;
		
	}
	public static String removeSpaces(String str) {
		String[] str_array = str.split("");
		String newString = "";
		for (int i = 0; i < str_array.length; i++){
			if (str_array[i].equals(" ")) str_array[i] = "%20";
			newString += str_array[i];
		}
		return newString;
	}
	
	public static int[][] rotate(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[i].length; j++) {
				final int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		
		return a;
	}
	
	@SuppressWarnings("rawtypes")
	public static LinkedList deleteNode(LinkedList list, int n) {
		list.remove(n-1);
		return list;
		
	}
	
	public static ArrayList<Integer> reverseAdd(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> sum = new ArrayList<Integer>();
		
		int s_a = a.size();
		int s_b = b.size();
		int m = Math.max(s_a, s_b);
		int carryingOver = 0;
		for (int i = 0; i < m; i++ ) {
			if ( i < s_a && i < s_b) {
				int add = a.get(i) + b.get(i) ;
				int r = add % 10;
				sum.add(r + carryingOver);
				carryingOver = 0;
				carryingOver = add /10;
			}
			if (i >= s_a) sum.add(b.get(i) + carryingOver);
			if (i >= s_b) sum.add(a.get(i) + carryingOver);
		}
		return sum;
	}
}
