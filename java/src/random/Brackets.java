package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Brackets {
	
	public static void main(String... args){
		
		brackets(3);
		
	}

	private static void brackets(int x) {
		
		HashMap<ArrayList<Character>, Integer> bracket = new HashMap<ArrayList<Character>, Integer>();
		int br_count =0;
		while(br_count < 2*x){
			if (bracket.isEmpty()) {
				ArrayList<Character> first = new ArrayList<Character>();
				first.add('(');
				bracket.put(first,  1);
			}else {
				Iterator<Entry<ArrayList<Character>, Integer>> it = bracket.entrySet().iterator();
				HashMap<ArrayList<Character>, Integer> t = new HashMap<ArrayList<Character>, Integer>();
				while(it.hasNext()){
					Entry<ArrayList<Character>, Integer> entry = it.next();
					ArrayList<Character> br = entry.getKey();
					int count = entry.getValue();
					if (count > 0){
						if (count < x){
							ArrayList<Character> br2 = new ArrayList<Character>();
							br2.addAll(br);
							br2.add('(');
							ArrayList<Character> br3 = new ArrayList<Character>();
							br3.addAll(br);
							br3.add(')');
							t.put(br2, count+1);
							t.put(br3, count -1);
						}else {
							ArrayList<Character> br3 = new ArrayList<Character>();
							br3.addAll(br);
							br3.add(')');
							t.put(br3, count -1);
						}
					}
				}
				bracket = new HashMap<ArrayList<Character>, Integer>();
				bracket.putAll(t);
			}
			br_count++;
		}
		
		System.out.println(bracket.keySet());

	}

}
