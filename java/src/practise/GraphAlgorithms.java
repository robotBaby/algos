package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class GraphAlgorithms {
	
	public static void main(String...args){
		
		Graph graph = new Graph();
		List<Integer> v = Arrays.asList(2,3,4,5,6,7,1,8,9);
		graph.addVertices(v);
		
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 6);
		graph.addEdge(4, 5);
		graph.addEdge(6, 5);
		graph.addEdge(3, 7);
		graph.addEdge(8, 3);
		graph.addEdge(9, 1);

		List<Integer> vf = graph.getVertices();
		HashMap<Integer, ArrayList<Integer>> ve = graph.getEdges();
		System.out.println(vf);
		System.out.println(ve);
		
		ArrayList<Integer> bfs = graph.bfs(2);
		ArrayList<Integer> dfs = graph.dfs(2, new ArrayList<Integer>(), new Stack<Integer>());

		System.out.println(bfs);
		System.out.println(dfs);
	}

}
