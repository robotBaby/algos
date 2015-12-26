package google_guide;

import java.util.ArrayList;
import java.util.Stack;

public class TreeBuilding {

	TreeNode tree = null;

	ArrayList<Double> inorderTraversalList2 = new ArrayList<Double>();

	
	
	TreeBuilding(ArrayList<Double> treeData) {
		if (treeData.isEmpty()) System.out.println("Warning empty tree");
		else {
			tree = new TreeNode(treeData.get(0), null, null);
			for (int i = 1; i < treeData.size(); i++) {
				tree = insert(tree, treeData.get(i));
			}
		}
	}
	private TreeNode insert(TreeNode tree, double data) {
			TreeNode newNode = new TreeNode(data, null, null);
			if (data < tree.val){
				if (tree.left == null) {tree.left = newNode;}
				else {
					final TreeNode leftTree = tree.left; 
					TreeNode newLeftTree = insert(leftTree, data);
					tree.left = newLeftTree;				}
			}
			else if (data > tree.val) {
				if (tree.right == null) {tree.right = newNode;}
				else {
					final TreeNode rightTree = tree.right; 
					TreeNode newRightTree = insert(rightTree, data);
					tree.right = newRightTree;
				}
			}
		return tree;
	}
	
	public ArrayList<Double> inorderTraversal(TreeNode tree) {
		TreeNode pointer = tree;
		ArrayList<Double> inorderTraversalList = new ArrayList<Double>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(pointer != null || !stack.isEmpty()) {
			if (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}
			else {
				TreeNode t = stack.pop();
				inorderTraversalList.add(t.val);
				pointer = t.right;
				
			}
		}

		
	return inorderTraversalList;
	}
	
	public ArrayList<Double> inorderTraversal2(TreeNode tree) {
		TreeNode leftNode = tree.left;
		TreeNode rightNode = tree.right;
		if (leftNode != null) inorderTraversal2(leftNode);
		inorderTraversalList2.add(tree.val);
		if (rightNode != null) inorderTraversal2(rightNode);
		return inorderTraversalList2;
	}

}
