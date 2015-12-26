//package google_guide;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
//public class OnlineCode {
//	
//   public static void main(String... args) {
//	   TreeNode left = new TreeNode(20);
//	   TreeNode right = new TreeNode(10);
//	   TreeNode tree = new TreeNode(5, left, right);
//	   ArrayList<Integer> lst = inorderTraversal(tree);
//	   System.out.println(lst);
//   }
//   public static ArrayList<Integer> inorderTraversal(TreeNode root) {
//       // IMPORTANT: Please reset any member data you declared, as
//       // the same Solution instance will be reused for each test case.
//        ArrayList<Integer> lst = new ArrayList<Integer>();
//
//       if(root == null)
//           return lst; 
//
//       Stack<TreeNode> stack = new Stack<TreeNode>();
//       //define a pointer to track nodes
//       TreeNode p = root;
//
//       while(!stack.empty() || p != null){
//
//           // if it is not null, push to stack
//           //and go down the tree to left
//           if(p != null){
//               stack.push(p);
//               p = p.left;
//
//           // if no left child
//           // pop stack, process the node
//           // then let p point to the right
//           }else{
//               TreeNode t = stack.pop();
//               lst.add(t.val);
//               p = t.right;
//           }
//       }
//
//       return lst;
//   }
//}
