package google_guide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class Dipa4 {
	
	private static Random rand = new Random();
	
	public static void main(String... args){
		
		HashMap<Integer, ArrayList<Integer>> pointLineMap = createData();
		int max = NumPointsForLine(pointLineMap);
	}

	private static int NumPointsForLine(
		HashMap<Integer, ArrayList<Integer>> pointLineMap) {
		HashMap<Integer, ArrayList<Integer>> linePointMap = new HashMap<Integer, ArrayList<Integer>>() ;
		int max = 1;
		Iterator<Entry<Integer, ArrayList<Integer>>> it = pointLineMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, ArrayList<Integer>> entry = it.next();
			int point = entry.getKey();
			ArrayList<Integer> lines = entry.getValue();
			for (Integer line : lines){
				if (linePointMap.containsKey(line)){
					ArrayList<Integer> temp = linePointMap.get(line);
					temp.add(point);
					linePointMap.put(line, temp);
					if (temp.size() > max) max = temp.size();
				}
				else {
					ArrayList<Integer> pointList = new ArrayList<Integer>();
					pointList.add(point);
					linePointMap.put(line, pointList);
				}
			}			
		}
		return max;
	}

	private static HashMap<Integer, ArrayList<Integer>> createData(){
		HashMap<Integer, ArrayList<Integer>> pointLineMap = new HashMap<Integer, ArrayList<Integer>>();
		
		int mapSize = Math.abs(rand.nextInt() % 10);
		for (int i = 0; i < mapSize; i++){
			ArrayList<Integer> lines = new ArrayList<Integer>();
			int j = 0;
			while (j < 3){
				int nextLine = Math.abs(rand.nextInt() % 10);
				if (!lines.contains(nextLine)) lines.add(nextLine);
				j++;
			}
			pointLineMap.put(i, lines);
		}
		
	return pointLineMap;
	}
}
