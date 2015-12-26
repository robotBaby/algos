package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class subset {
	
	public static void main(String...args){
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		ArrayList<ArrayList<Integer>> subsets = generateSubset(set);
		System.out.println(subsets);
	}

	private static ArrayList<ArrayList<Integer>> generateSubset(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> e_0 = new ArrayList<Integer>();
		ArrayList<Integer> e_1 = new ArrayList<Integer>();
		e_0.add(set.get(0));
		e_1.add(set.get(1));
		subsets.add(e_0);
		subsets.add(e_1);
		ArrayList<Integer> common = new ArrayList<Integer>();
		common.add(set.get(0));
		common.add(set.get(1));
		subsets.add(common);
		
		for (int i = 2; i < set.size(); i++){
			ArrayList<Integer> e_i = new ArrayList<Integer>();
			e_i.add(set.get(i));
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> e : subsets){
				ArrayList<Integer> ne = new ArrayList<Integer>();
				ne.add(set.get(i));
				ne.addAll(e);
				temp.add(ne);
			}
			subsets.addAll(temp);
			subsets.add(e_i);
		}

		subsets.add(new ArrayList<Integer>());
		return subsets;
	}

}
