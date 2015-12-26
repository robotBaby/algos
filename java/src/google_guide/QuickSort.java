package google_guide;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	static String name = "Arindrima";
	static char[] a = new char[name.length()];
	static char[] b = new char[name.length()];


	static Random rand = new Random();
	public static void main(String...strings){
		for (int i = 0; i < name.length(); i++){
			a[i] = name.toLowerCase().charAt(i);
		}
		for (int i = 0; i < name.length(); i++){
			int r = Math.abs(rand.nextInt() % name.length());
			b[i] = name.toLowerCase().charAt(r);
		}
		System.out.println(Arrays.toString(a));
//		b = a;
		System.out.println(Arrays.toString(b));
		sort(0, a.length -1);
		sort(0, b.length -1);
		for (int i = 0; i < a.length; i++){
			if (a[i] != b[i]) {
				System.out.println("Not an anagram!");
				break;
			}
			if (i == a.length - 1) System.out.println("Yes, this is an anagram");
		}
		
	}
	private static void sort(int l, int h) {
        
        int i = l;
        int j = h;
        int pivot = l;
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (a[i] < a[pivot]) {
                i++;
            }
            while (a[j] > a[pivot]) {
                j--;
            }
            if (i <= j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;                
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (l < j)
            sort(l, j);
        if (i < h)
            sort(i, h);
    }

}
