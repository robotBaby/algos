package random;

import java.util.Arrays;

public class MatrixSearch {
	
	public static void main(String...args){
		int[][] matrix = new int[5][3];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++){
				int a = i*j + i+j;
				matrix[i][j] = a;
			}
			System.out.println(Arrays.toString(matrix[i]));
		}
		boolean found = search(matrix, 15);
		System.out.println(found);
		
	}

	private static boolean search(int[][] matrix, int x) {
		boolean found = false;
		int i = 0;
		int j = matrix[0].length -1;
		while(i < matrix.length && j >= 0){
			if (matrix[i][j] == x) {
				found = true;
				break;
			}
			else if (matrix[i][j] < x) i++;
			else j--;
		}
		
		return found;
	}

}
