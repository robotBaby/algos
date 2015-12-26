package random;

import java.util.Arrays;
import java.util.Random;

public class FillPaint {
	static Random rand = new Random();
	
	public static void main(String...args){
		int[][] color = new int[4][4];
		boolean[][] colorB = new boolean[4][4];
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color[0].length; j++){
				int a = Math.abs(rand.nextInt()% color.length);
				color[i][j] = a;
			}
		}
		
		System.out.println(Arrays.deepToString(color));
		boolean[][] newFill = fillPaint(color, colorB, 2,3);
		int newColor = 5; 
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color[0].length; j++){
				if (colorB[i][j]) color[i][j] = newColor;
			}
		}
		System.out.println(Arrays.deepToString(color));
		
	}

	private static boolean[][] fillPaint(int[][] color, boolean[][] colorB, int x, int y) {
		int fillColor = color[x][y];
		
		if (x < color.length -1){
			if (color[x+1][y] == fillColor && !colorB[x+1][y]) {
				colorB[x+1][y] = true;
				color[x+1][y] = fillColor;
				fillPaint(color, colorB, x+1, y);
			}
		}
		if (x >0){
			if (color[x-1][y] == fillColor && !colorB[x-1][y]) {
				colorB[x-1][y] = true;
				color[x-1][y] = fillColor;
				fillPaint(color, colorB, x-1, y);
			}
		}
		if (y < color[0].length-1 ){
			if (color[x][y+1] == fillColor && !colorB[x][y+1]) {
				colorB[x][y+1] = true;
				color[x][y+1] = fillColor;
				fillPaint(color, colorB, x, y+1);
			}	
		}
		if (y > 0){
			if (color[x][y-1] == fillColor && !colorB[x][y-1]) {
				colorB[x][y-1] = true;
				color[x][y-1] = fillColor;
				fillPaint(color, colorB, x, y-1);
			}
		}
		return colorB;
	}

}
