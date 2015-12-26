package google_guide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class WebCrawling {
	ArrayList<Integer> dfsList = new ArrayList<Integer>();
	ArrayList<Integer> bfsList = new ArrayList<Integer>();
	
	
	public void DFS(TreeMap<Integer, ArrayList<Integer>> linkMap, int node) {
		if (!dfsList.contains(node)) dfsList.add(node);
		ArrayList<Integer> connections = linkMap.get(node);
		for (int c : connections) {
			if (!dfsList.contains(c)) {
				dfsList.add(c);
				DFS(linkMap, c);
			}	
		}				
	}

	public void BFS(TreeMap<Integer, ArrayList<Integer>> linkMap, int node) {
		boolean stop = true;
		if (!bfsList.contains(node)) bfsList.add(node);
		ArrayList<Integer> connections = linkMap.get(node);
		for (int c : connections) if (!bfsList.contains(c)) bfsList.add(c);
		for (Integer key : linkMap.keySet()) if (!bfsList.contains(key)) stop = false;
		for (int c : connections) 
			if (!stop) BFS(linkMap, c);
		}
}
