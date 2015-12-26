package practise;

import java.util.ArrayList;
import java.util.Random;


public class BSTImplementation {

	
	public static void main(String...args){
		BinarySearchTree tree = new BinarySearchTree();
//		for (int i = 0; i < 10; i++){
//			Random rand = new Random();
//			int a = Math.abs((rand.nextInt() % 20));
//			System.out.println(a);
//			tree.insertOrupdate(a);
//		}
//		for (int i = 3; i < 10; i +=4){
//			tree.delete(i);
//		}
//		ArrayList<Integer> traversal = tree.traversal("inorder");
//		System.out.println(traversal);
//		traversal = tree.traversal("preorder");
//		System.out.println(traversal);
//		traversal = tree.traversal("postorder");
//		System.out.println(traversal);

//		boolean found = tree.search(3);
		
		tree.insertOrupdate(3);
		tree.insertOrupdate(5);
		tree.insertOrupdate(1);
		tree.insertOrupdate(2);
		tree.insertOrupdate(4);
		tree.insertOrupdate(7);
		tree.insertOrupdate(6);

		ArrayList<Integer> dfs = tree.DFS();
		System.out.println(dfs);
//		ArrayList<Integer> levelItems = tree.getItemsAtLevel(4);
//		System.out.println(tree.findLeafDepth(6));
//		
//		int commonAncestor = tree.commonAncestor(6, 4);
//		System.out.println(commonAncestor);
		
//		for (int i = 0; i < bfs.size(); i++){
//			int depth = tree.findLeafDepth(bfs.get(i));
//			System.out.println(bfs.get(i) + " : " + depth);
//		}
		
//		int minDepth = tree.minDepth();
//		int maxDepth = tree.maxDepth();
//		System.out.println("MinDepth: " + minDepth + " and MaxDepth: " + maxDepth + ". Tree Balance: " + ((maxDepth - minDepth) > 1) );
	}
}
