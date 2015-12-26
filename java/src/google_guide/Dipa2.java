package google_guide;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Dipa2 {
	
	private static Random rand = new Random();
	
	@SuppressWarnings("unused")
	public static void main(String... args) {
		ArrayList<Double> treeData = new ArrayList<Double>();
		for (int i = 0; treeData.size() < 5; i++){
			double data = (double) Math.abs(rand.nextInt()) % 10 ;
			if (!treeData.contains(data)) treeData.add(data);
		}
		TreeBuilding treeBuilding = new TreeBuilding(treeData);
		TreeNode tree = treeBuilding.tree;
		ArrayList<Double> list1 = treeBuilding.inorderTraversal(tree);
		ArrayList<Double> list2 = treeBuilding.inorderTraversal2(tree);

		////////////////////////////////////////////////////////////////////
		
		BitCount bitcount = new BitCount();
		int count1 = bitcount.bitCount(156);
		int count2 = bitcount.bitCount(156);

	    ///////////////////////////////////////////////////////////////////

		TreeMap<Integer, ArrayList<Integer>> linkMap = new TreeMap<Integer, ArrayList<Integer>>();
		for (int i = 0; linkMap.size() < 5; i++) {
			int links = Math.abs(rand.nextInt() % 5);
			int key = Math.abs(rand.nextInt() % 5);
			ArrayList<Integer> thisKeyArray = new ArrayList<Integer>();
			for (int j = 0; j < links; j++) {
				int thisValue = Math.abs(rand.nextInt() % 5);
				if (thisValue != key && !thisKeyArray.contains(thisValue)) thisKeyArray.add(thisValue);
			}
			if (!thisKeyArray.isEmpty()) linkMap.put(key, thisKeyArray);
		}
		
		System.out.println(linkMap);
		WebCrawling web = new WebCrawling();
		web.DFS(linkMap, 3);
		web.BFS(linkMap, 3);
		System.out.println(web.dfsList);
		System.out.println(web.bfsList);
		
	}	
	


}
