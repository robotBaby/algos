package google_guide;

import java.util.LinkedList;

public class Alex2 {
	
	public static void main(String...strings){
		LinkedList<Integer> a = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) a.add(i);
		int l = a.size() - 4;
		int b = a.get(l);
		System.out.println(a);
		
	}

}
