package interviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Tree {
	
	static Random rand = new Random();
	
	public static void main(String... args){
		int[] tree = {-1,1,2,3,0,0,4,0};
		System.out.println(Arrays.toString(tree));
		int curr = 1;
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		Stack<Integer> last = new Stack<Integer>();
		last.add(curr);
		
		while(!last.isEmpty()){
			if (curr <= tree.length && tree[curr] != 0) {
				curr = 2*curr;
				last.add(curr);
			}
			else {
				curr = last.pop();
				int t = 2*curr + 1;
				if (curr < tree.length && (t > tree.length || tree[t] == 0)) {
					leaves.add(curr);
					}
				curr++;
				last.add(curr);
				if (curr == tree.length) break;
			}
		}
		
		System.out.println(leaves);
		
	}


}
