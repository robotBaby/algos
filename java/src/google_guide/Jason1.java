package google_guide;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Jason1 {
	public static void main(String...strings){
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(2);
		
		Set<Integer> b = new HashSet<Integer>();
		for (int i = 0; i < a.size(); i++){
			b.add(a.get(i));
		}
		
		if (b.size() != a.size()) System.out.println("Loop detected");
	}

}
