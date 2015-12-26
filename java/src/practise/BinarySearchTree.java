package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	
	private class Node{
		int data;
		Node left, right;
		
		Node(){
			this.left = null;
			this.right = null;
			this.data = -1;
		}
		
		Node(int data){
			this.data = data;
		}
		
		public int getData(){
			return data;
		}
		public void setData(int data){
			this.data = data;
		}
		
		public Node getLeft(){
			return left;
		}
		public void setLeft(Node left){
			this.left = left;
		}
		
		public Node getRight(){
			return right;
		}
		public void setRight(Node right){
			this.right = right;
		}
	}
	
	
	Node root = new Node();
	
	public boolean isEmpty(){
		return root.getData() == -1;
	}
	
	public void insertOrupdate(int k){
		
		root = InsertOrUpdate(k, root);
	}

	private Node InsertOrUpdate(int k, Node root) {
		if (root.getData() == -1){
			Node newNode = new Node(k);
			Node newNodert = new Node();
			Node newNodelt = new Node();
			newNode.setLeft(newNodelt);
			newNode.setRight(newNodert);
			root = newNode;
		} 
		else if (k > root.getData()){
			Node rt = root.getRight();
			Node newNode = InsertOrUpdate(k, rt);
			root.setRight(newNode);
		} else if (k < root.getData()){
			Node lt = root.getLeft();
			Node newNode = InsertOrUpdate(k, lt);
			root.setLeft(newNode);
		}
		
		return root;
	}
	public int findLeafDepth(int k){
		int depth = findLeafDepth(k, root);
		return depth;
	}
	
	private int findLeafDepth(int k, Node root) {
		int depth;
		int root_val = root.getData();
		if (root_val == -1) depth = -1;
		else if (k > root_val) {
			depth = 1+ findLeafDepth(k, root.getRight());
		} else if (k < root_val){
			depth = 1+ findLeafDepth(k, root.getLeft());
		} else {
			depth = 0;
		}
		
		return depth;
	}
	
	public int minDepth(){
		int min = minDepth(root);
		return min;
	}

	private int minDepth(Node root) {

		int mindepth;
		if (root.getData() == -1){
			mindepth = 0;
		} else {
			Node lt = root.getLeft();
			Node rt = root.getRight();
			mindepth = 1 + Math.min(minDepth(lt), minDepth(rt));
		}
		return mindepth;
	}
	
	public int maxDepth(){
		int max = maxDepth(root);
		return max;
	}

	private int maxDepth(Node root) {

		int maxdepth;
		if (root.getData() == -1){
			maxdepth = 0;
		} else {
			Node lt = root.getLeft();
			Node rt = root.getRight();
			maxdepth = 1 + Math.max(maxDepth(lt), maxDepth(rt));
		}
		return maxdepth;
	}


	public boolean search(int k){
		boolean found = search(k, root);
		return found;
	}
	
	private boolean search(int k, Node root) {
		boolean return_result = false;
		if (root.getData() == -1) {
			return_result = false;
		}
		else if (root.getData() == k){
			return_result = true;
		} else if (k > root.getData()){
			return_result = search(k, root.getRight());
		} else if (k < root.getData()) {
			return_result = search(k, root.getLeft());
		}
		
			
		return return_result;
	}
	
	public void delete(int k){
		
		if (search(k)){
			root = delete(root, k);
		} else {
			System.out.println("there is not node to delete");
		}
	}

	private Node delete(Node root, int k) {
		Node lt = root.getLeft();
		Node rt = root.getRight();
		if (root.getData() == k){
		if (lt.getData() == -1 && rt.getData() == -1){
			root.setData(-1);
		} else if ( lt.getData() == -1 && rt.getData() != -1){
			root.setData(rt.getData());
			root.setLeft(rt.getLeft());
			root.setRight(rt.getRight());
		} else if (lt.getData() != -1 && rt.getData() == -1){
			root.setData(lt.getData());
			root.setLeft(lt.getLeft());
			root.setRight(lt.getRight());
		} else if (lt.getData() != -1 && rt.getData() != -1){
			while(rt.getLeft().getData() != -1){
				rt = rt.getLeft();
			}
			root.setData(rt.getData());
			delete(rt, k);
			}
		} else if (k > root.getData()){
			root.setRight(delete(rt, k));
		} else {
			root.setLeft(delete(lt, k));
		}
		
		return root;
	}

	public ArrayList<Integer> traversal(String typeOfTraversal){
		ArrayList<Integer> traversal = new ArrayList<Integer>();
		switch(typeOfTraversal){
		case "inorder" :
			traversal = inorder(root, new ArrayList<Integer>());
			break;
		case "preorder":
			traversal = preorder(root, new ArrayList<Integer>());
			break;
		case "postorder":
			traversal = postorder(root, new ArrayList<Integer>());
			break;
		default:
			System.out.println("No such traversal type");
		}
				
				
		return traversal;
	}

	private ArrayList<Integer> postorder(Node root, ArrayList<Integer> traversal) {
		
		if(root.getData() != -1){
			Node lt = root.getLeft();
			postorder(lt, traversal);
			Node rt = root.getRight();
			postorder(rt, traversal);
			traversal.add(root.getData());
		}
		
		return traversal;
	}

	private ArrayList<Integer> inorder(Node root, ArrayList<Integer> traversal) {
		
		if(root.getData() != -1){
			Node lt = root.getLeft();
			inorder(lt, traversal);
			traversal.add(root.getData());
			Node rt = root.getRight();
			inorder(rt, traversal);
		}
		
		return traversal;
	}
	
	private ArrayList<Integer> preorder(Node root, ArrayList<Integer> traversal) {
		
		if(root.getData() != -1){
			traversal.add(root.getData());
			Node lt = root.getLeft();
			preorder(lt, traversal);
			Node rt = root.getRight();
			preorder(rt, traversal);
		}
		
		return traversal;
	}
	
	public ArrayList<Integer> BFS(){
		ArrayList<Integer> bfs_result =bfs();
		return bfs_result;
	}
	public ArrayList<Integer> bfs(){
		ArrayList<Integer> b = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()){
			Node r = q.poll();
			if (r.getData() != -1) b.add(r.getData());
			Node lt = r.getLeft();
			Node rt = r.getRight();
			if (lt.getData() != -1) q.add(lt);
			if (rt.getData() != -1) q.add(rt);
		}
	return b;

	}
	
	public ArrayList<Integer> DFS(){
		ArrayList<Integer> d = new ArrayList<Integer>();
		d = dfs(root, d);
		return d;
	}
	private ArrayList<Integer> dfs(Node root, ArrayList<Integer> d) {

			if (root.getData() != -1) {
				Node lt = root.getLeft();
				Node rt = root.getRight();
				d.add(root.getData());
				if (lt.getData() != -1){
					dfs(lt, d);
				}
				if (rt.getData() != -1){
					dfs(rt, d);
				}
			}
			
		return d;
	}

	public ArrayList<Integer> getItemsAtLevel(int depth){

		ArrayList<Integer> levelItems = new ArrayList<Integer>();

		levelItems = getItemsAtLevel(depth, levelItems);
		return levelItems;
	}

	private ArrayList<Integer> getItemsAtLevel(int depth,  ArrayList<Integer> levelItems) {
		Queue<Node> q = new LinkedList<Node>();
		Queue<Integer> l = new LinkedList<Integer>();
		q.add(root);
		l.add(0);
		while(!q.isEmpty()){
			Node thisNode = q.poll();
			int thisLevel = l.poll();
			if (thisLevel == depth) levelItems.add(thisNode.getData());
			Node lt = thisNode.getLeft();
			Node rt = thisNode.getRight();
			if (lt.getData() != -1){
				q.add(lt);
				l.add(thisLevel + 1);
			}
			if (rt.getData() != -1){
				q.add(rt);
				l.add(thisLevel + 1);
			}
		}
		
		return levelItems;
	}
	public int commonAncestor(int i, int j){
		int commonAnces = commonAncestor(i,j, root);
		return commonAnces;
	}
	
	public int commonAncestor(int i, int j, Node root){
		int root_val = root.getData();
		int common = 0;
		if (i==j) common = i;
		else if ((i == root_val && j != root_val) || (i != root_val && j == root_val)) {
			common = root_val;
		} else if ( i < root_val && j < root_val){
			Node lt = root.getLeft();
			common = commonAncestor(i,j, lt);
		} else if (i > root_val && j > root_val){
			Node rt = root.getRight();
			common = commonAncestor(i,j, rt);
		} else if ((i > root_val && j < root_val) || (i < root_val && j > root_val)){
			common = root_val;
		}
		return common;
	}

}
