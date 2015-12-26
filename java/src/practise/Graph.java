package practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	List<Integer> vertices = new ArrayList<Integer>();
	HashMap<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
	
	public void addVertices(List<Integer> v){
		vertices.addAll(v);
	}
	
	public void addVertice(int v){
		vertices.add(v);
	}
	
	public void addEdges(HashMap<Integer, ArrayList<Integer>> e){
		edges.putAll(e);
	}
	
	public void addEdge(int u, int v){
		if (edges.containsKey(u)){
			edges.get(u).add(v);
		} else {
			ArrayList<Integer> nu = new ArrayList<Integer>();
			nu.add(v);
			edges.put(u, nu);
		}
		
		if (edges.containsKey(v)){
			edges.get(v).add(u);
		} else {
			ArrayList<Integer> nv = new ArrayList<Integer>();
			nv.add(u);
			edges.put(v, nv);
		}
	}
	
	public HashMap<Integer, ArrayList<Integer>> getEdges(){
		return edges;
	}
	
	public List<Integer>  getVertices(){
		return vertices;
	}
	
	
	public ArrayList<Integer> bfs(int start){
		ArrayList<Integer> searchResult = new ArrayList<Integer>();
		searchResult.add(start);
		Queue<Integer> visited = new LinkedList<Integer>();
		visited.add(start);
		while(!visited.isEmpty()){
			int thisVertex = visited.poll();
			ArrayList<Integer> nextVertices = edges.get(thisVertex);
			for (int v : nextVertices) {
				if (!searchResult.contains(v)) {
					visited.add(v);
					searchResult.add(v);
				}
			}
		}
		
		return searchResult;
	}
	
	public ArrayList<Integer> dfs(int start, ArrayList<Integer> searchResult, Stack<Integer> visited){
		searchResult.add(start);
		visited.add(start);
		while(!visited.isEmpty()){
			int thisVertex = visited.pop();
			ArrayList<Integer> nextVertex = edges.get(thisVertex);
			for (int v : nextVertex){
				if (!searchResult.contains(v)) {
					dfs(v, searchResult, visited);
				}
			}
		}
		
		return searchResult;
	}

}
