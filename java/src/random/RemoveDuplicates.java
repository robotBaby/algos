package random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveDuplicates {
	
	
	public static void main(String...args){
		String filename = "duplicate.txt";
		
		ArrayList<Integer> duplicateLines = readFile(filename);
		writeFile(filename, duplicateLines);
	}

	private static void writeFile(String filename,
			ArrayList<Integer> duplicateLines) {

		
	}

	private static ArrayList<Integer> readFile(String filename) {
		
		File f = new File (filename);
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while((line = br.readLine()) != null){
				if (!lines.contains(line)) lines.add(line);
			}
			
		br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	System.out.println(lines);
	return null;
	}

}
