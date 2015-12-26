package practise;

public class RedBlackTreeImplementation {
	
	public static void main(String...args){
		
		RedBlackTree tree = new RedBlackTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);


		
		tree.delete(6);
		tree.treetraversal();

	}

}
