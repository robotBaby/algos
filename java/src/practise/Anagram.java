package practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Anagram {
	
	public static void main(String...args){
		
		ArrayList<String> a = anagram("ab");
		String reverseString = reverse("word");
//		printmultiplicationtable(2,5);
//		sumFile("text.txt");
		System.out.println(Integer.toBinaryString((5>>2)&1));
	}

	private static void sumFile(String string) {
		try {
		BufferedReader br = new BufferedReader(new FileReader(new File(string)));
		int sum = 0;
		String line;
		while((line = br.readLine()) != null){
			sum += Integer.parseInt(line);
		}
		System.out.println(sum);
		} catch(Exception e){
			
		}
	}

	private static void printmultiplicationtable(int x, int y) {
		 for ( int i = 1; i <= x; i++ ) {
	            for ( int j = 1; j <= y; j++ ) {
	                System.out.print ( String.format ( "%4d", j * i ));
	            }
	            System.out.println();
	        }
	}

	private static String reverse(String string) {
		String reverseString = "";
		
		for (int i = string.length()-1; i >= 0 ; i--){
			reverseString += string.substring(i, i+1);
		}
		return reverseString;
	}

	private static ArrayList<String> anagram(String string) {
		ArrayList<String> anagramList = new ArrayList<String>();
		if (string.length() >2){
			for (int j = 0; j < string.length(); j++){
				String v = string.substring(j, j+1);
				String newString = "";
				for (int k = 0; k < string.length(); k++){
					if (k != j) newString += string.substring(k, k+1);
				}
				ArrayList<String> anagram = anagram(newString);
				for (String a : anagram){
					if (!anagramList.contains(v+a)) anagramList.add(v+a);
				}
			}
		} else {
			if (!anagramList.contains(string))anagramList.add(string);
			String anagram = "";
			anagram += string.substring(1,2);
			anagram += string.substring(0,1);
			if (!anagramList.contains(anagram)) anagramList.add(anagram);
		}
		
	return anagramList;
	}

}
