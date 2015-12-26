package interviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class StacksAndQues {
	
		static int f;
		static int l;
		static int m;
		static final int array_size = 10;
		static int[] array = new int[array_size];

		public static void main(String... args){
			f = 0;
			l = array_size -1;
			m = f;
			ArrayList<Integer> fl = new ArrayList<Integer>();
			ArrayList<Integer> ll = new ArrayList<Integer>();
			ArrayList<Integer> ml = new ArrayList<Integer>();

			Random rand = new Random();
			for (int i = 0; i < array.length; i++){
				int j = Math.abs(rand.nextInt() % 3);
				if (j == 0){
					if (f==m){
					array[f++] = i;
					m++;
					}
					else if (f<m){
						for (int k = m; k >f; k--) {
							int temp = array[k-1];
							array[k] = temp;
						}
						array[f] = i;
						f++;
						m++;
					}
					fl.add(i);
				}
				else if (j ==1){
					array[l--] = i;
					ll.add(i);
				}
				else if (j==2){
					array[m++] = i;
					ml.add(i);
				}				
			}
			
			
		
		System.out.println(Arrays.toString(array));
//		System.out.println(array[peek(2,ml.size()-1)]);
		for (int i = 0; i < ll.size(); i++) pop(1);
		System.out.println(fl);
		System.out.println(ll);
		System.out.println(ml);

			
			
		}
		
	public static int peek(int whichStack, int whichElement){
		int e = 0;
		if (whichStack == 0){
			e = whichElement;
		}
		else if (whichStack == 1){
			e = array_size -1-whichElement;
		}
		else if (whichStack == 2){
			e = f+ whichElement;
		}
		return e;
	}
	
	public static void pop(int whichStack){
		if (whichStack == 0){
			System.out.println(array[f-1]);
			f--;
		}
		else if (whichStack == 1){
			System.out.println(array[l+1]);
			l++;
		}
		else if (whichStack == 2){
			System.out.println(array[m-1]);
			m--;
		}
	}

}
