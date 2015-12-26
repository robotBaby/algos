package practise;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {
	
	private class Node{
		int data;
		String color;
		Node parent;
		Node left;
		Node right;
		
		Node(){
			this.data = -1;
			this.color = "black";
			this.left = null;
			this.right = null;
		}

		
		Node (int k, Node left, Node right, String color){
			this.data = k;
			this.color = color;
			this.left = left;
			this.right = right;
		}		
		public int getData(){
			return this.data;
		}		
		public void setData(int k){
			this.data = k;
		}		
		public Node getParent(){
			return this.parent;
		}		
		public void setParent(Node parent){
			this.parent = parent;
		}		
		public Node getLeft(){
			return this.left;
		}		
		public void setLeft(Node left){
			this.left = left;
		}
		public Node getRight(){
			return this.right;
		}
		public void setRight(Node right){
			this.right = right;
		}
		
		public String getColor(){
			return this.color;
		}
		public void setColor(String color){
			this.color = color;
		}
		
		
		
	}
	
	
	Node root = new Node();
	
	public boolean isRed(Node x){
		if (x == null ) return false;
		else return x.getColor().equals("red");
	}
	public boolean isEmpty(){
		return (root.getData() == -1) ? true : false;
	}
	
	public void insert(int k){
		root = insert(root, k);
		root.setColor("black");
	}

	private Node insert(Node root, int k){
		int root_val = root.getData();
		if ( root_val == -1) {
			root = new Node(k, new Node(), new Node(), "red" );
		} else {
			if (k == root_val) System.out.println("Duplicates not permitted in BST");
			else if (k > root_val){
				Node new_rt = insert(root.getRight(), k);
				root.setRight(new_rt);
			} else {
				Node new_lt = insert(root.getLeft(), k);
				root.setLeft(new_lt);
			}
		} 
	
		Node lt = root.getLeft();
		Node rt = root.getRight();
		if(isRed(rt) && !isRed(lt)) root = rotateLeft(root);
		if (isRed(lt) && isRed(lt.getLeft())) root = rotateRight(root);
		if (isRed(rt) && isRed(rt)) flipcolor(root);
		return root;
	}
	
	
	public void delete(int k){
		root = delete(root, k);
	}
	
	
	private Node delete(Node root, int k) {
		int root_val = root.getData();
		if (root_val == -1){
			System.out.println("No node founf in te tree with the given value");
		} else {
			if (k == root_val) {
				Node lt = root.getLeft();
				Node rt = root.getRight();
				
				if (lt.getData() != -1 && rt.getData() != -1){
					while(rt.getLeft().getData() != -1){
						rt = rt.getLeft();
					}
					int replacement = rt.getData();
					delete(replacement);
					root.setData(replacement);
					
				} else if (lt.getData() == -1 && rt.getData() != -1){
					root.setData(rt.getData());
					root.setRight(rt.getRight());
				}else if (rt.getData() == -1 && lt.getData() != -1){
					root.setData(lt.getData());
					root.setLeft(lt.getLeft());
				} else {
					root = new Node();
				}
				
			} else if (k > root_val) {
				Node new_rt = delete(root.getRight(), k);
				root.setRight(new_rt);
			} else {
				Node new_lt = delete(root.getLeft(), k);
				root.setLeft(new_lt);
			}
		}
		
		Node lt = root.getLeft();
		Node rt = root.getRight();
		if(isRed(rt) && !isRed(lt)) root = rotateLeft(root);
		if (isRed(lt) && isRed(lt.getLeft())) root = rotateRight(root);
		if (isRed(rt) && isRed(rt)) flipcolor(root);
		
		return root;
	}
	private  void flipcolor(Node root) {
		if (root.getColor().equals("red")) {
			root.setColor("black");
		} else root.setColor("red");
		if (root.getLeft().getColor().equals("red")) {
			Node nw_lt = root.getLeft();
			nw_lt.setColor("black");
			root.setLeft(nw_lt);
		} else {
			Node nw_lt = root.getLeft();
			nw_lt.setColor("red");
			root.setLeft(nw_lt);
		}
		if (root.getRight().getColor().equals("red")) {
			Node nw_rt = root.getRight();
			nw_rt.setColor("black");
			root.setRight(nw_rt);
		} else {
			Node nw_rt = root.getRight();
			nw_rt.setColor("red");
			root.setRight(nw_rt);
		}
		
	}

	private Node rotateLeft(Node root) {
		Node rt = root.getRight();
		root.setRight(rt.getLeft());
		String color = root.getColor();
		root.setColor("red");
		rt.setLeft(root);
		rt.setColor(color);
		return rt;
	}

	private Node rotateRight(Node root) {
		Node lt = root.getLeft();
		root.setLeft(lt.getRight());
		String color = root.getColor();
		root.setColor("red");
		lt.setRight(root);
		lt.setColor(color);
		return lt;
	}

	public void treetraversal(){
		treetraversal(root, 0);
	}
	
	public void treetraversal(Node root, int level){

			Node lt = root.getLeft();
			if (lt.getData() != -1) treetraversal(lt, level+1);
			System.out.println(root.getData() + ":" + root.getColor() + ":" + level);
			Node rt = root.getRight();
			if (rt.getData() != -1) treetraversal(rt, level+1);
	}
}
