package google_guide;

import java.util.ArrayList;

public class Alex3 {
	
	public static void main(String...strings){
		int [] A = {3,9,20,15,7};
		ArrayList<ArrayList<Integer>> valueLevels = new ArrayList<ArrayList<Integer>>(); 
		int scanner = 0;
		while(scanner < A.length){
			ArrayList<Integer> thisLevel = new ArrayList<Integer>();
			if (valueLevels.isEmpty()){
				thisLevel.add(A[scanner++]);
			}
			else {
				ArrayList<Integer> prevLevel = valueLevels.get(valueLevels.size() - 1);
				int max = prevLevel.get(prevLevel.size() - 1);
				while(scanner < A.length && A[scanner] < max){
					thisLevel.add(A[scanner++]);
				}
				if (scanner < A.length && A[scanner] > max) {
					thisLevel.add(A[scanner++]);
				}
			}
			valueLevels.add(thisLevel);
		}
		
		System.out.println(valueLevels);
	}

}
