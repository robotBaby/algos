package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayToBST {

	public static void main(String...strings){
		int[] a = {2,3,4,5,6,7,8,9};
		Queue<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(a.length-1);
		ArrayList<Integer> bst = createTree(a);
		System.out.println(bst);
	}

	private static ArrayList<Integer> createTree(int[] a) {
		ArrayList<Integer> tree = new ArrayList<Integer>();
		Queue<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(a.length-1);
		
		while(!list.isEmpty()){
			int l = list.poll() ;
			int u = list.poll();
			int m = (l+u)/2;
			tree.add(a[m]);
			if (m > l) {
				list.add(l);
				list.add(m-1);
			}
			if (m < u) {
				list.add(m+1);
				list.add(u);
			}
		}

		
		
		return tree;
	}
}
