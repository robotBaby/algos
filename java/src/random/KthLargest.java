package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KthLargest {

	
	public static void main(String...args){
		
		ArrayList<Character> java = new ArrayList<Character>();
		java.add('0');
		java.add('1');
		char[] qm = {'0', '1'};
		for (char i : qm){
			java.add(i);
			ArrayList<ArrayList<Character>> a = permute(java, '\u0000');
			for (ArrayList<Character> ai : a){
				System.out.println(ai);
				}
			java.remove(java.size() -1);
		}
	}

	private static ArrayList<ArrayList<Character>> permute(ArrayList<Character> e, char f_e) {
		ArrayList<ArrayList<Character>> npe = new ArrayList<ArrayList<Character>>();

		if (e.size() ==2){
			npe.add(e);
			ArrayList<Character> nw = new ArrayList<Character>();
			nw.add(e.get(1));
			nw.add(e.get(0));
			npe.add(nw);
		} else {
			for (int i = 0; i < e.size(); i++){
				char fixed_e = e.get(i);
				ArrayList<Character> ne = new ArrayList<Character>();
				for (int j =0; j < e.size(); j++){
					if (j!=i) ne.add(e.get(j));
				}

				for (ArrayList<Character> abc :permute(ne, fixed_e)){
					ArrayList<Character> nw = new ArrayList<Character>();
					nw.add(fixed_e);
					nw.addAll(abc);
					if (!npe.contains(nw)) npe.add(nw);
				};
			}
			
		}
		
		return npe;
	}
}
