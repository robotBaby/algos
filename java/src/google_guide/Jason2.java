package google_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Jason2 {
	static Random rand = new Random();
	public static void main(String...strings){
		ArrayList<int[]> a = new ArrayList<int[]>();
		for (int i = 0 ; i < 10; i++){
			int[] m = new int[5];
			for (int j = 0; j < m.length; j++) m[j] = Math.abs(rand.nextInt() %10);
			Arrays.sort(m);
			a.add(m);
		}
		
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++){
			p.add(0);
		}
		int[] f = new int[a.size()*5];
		int k = 0;
		while(k<f.length){
			int[] p_a = new int[p.size()];
			for (int i = 0; i < p_a.length; i++){
				p_a[i] = a.get(i)[p.get(i)];
			}
			int min = Integer.MAX_VALUE;
			int min_id = 0;
			for (int i = 0; i < p_a.length; i++){
				if (p_a[i]< min) {
					min = p_a[i];
					min_id = i;
				}
			}
			f[k] = min;
			if (p.get(min_id) > 3){
				a.remove(min_id);
				p.remove(min_id);
			}
			else {
				p.set(min_id, p.get(min_id)+1);
			}
			k++;
		}
		
		System.out.println(Arrays.toString(f));
	}

}
