package random;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayDiff {

	public static void main(String...strings){
		int[] a = {1,1,5,6,9,16,27};
		HashMap<Integer, ArrayList<PairWise>> diffMap = createDiff(a);
		ArrayList<PairWise> result = diffMap.get(4);
		for (PairWise p: result){
			System.out.println(a[p.getFirst()] + "," + a[p.getSecond()]);
		}
		
		
		
		
	}

	private static HashMap<Integer, ArrayList<PairWise>> createDiff(int[] a) {

		HashMap<Integer, ArrayList<PairWise>> diffMap = new HashMap<Integer, ArrayList<PairWise>>();
		for (int i = 0; i < a.length; i++){
			for (int j = i+1; j < a.length; j++){
				int diff = Math.abs(a[i] - a[j]);
				if (!diffMap.containsKey(diff)) diffMap.put(diff, new ArrayList<PairWise>());				
				diffMap.get(diff).add(new PairWise(i,j));
			}
		}
		return diffMap;
	}
	
}
class PairWise{
	
	int i;
	int j;
	public PairWise(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public int getFirst() {
		return i;
	}
	public int getSecond(){
		return j;
	}
}
