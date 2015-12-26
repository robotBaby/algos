package google_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Alex1 {
	
	static ArrayList<String> w = new ArrayList<String>();
	static HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
	
	public static void main(String...strings){
//		w.add("My");
		w.add("name");
//		w.add("is");
//		w.add("bab");
//		w.add("Datta");
		createAnagrams(w);
		System.out.println(anagrams);
		
	}

	private static void createAnagrams(ArrayList<String> w2) {
		for (String word : w){
			word = word.toLowerCase();
			char[] letters = new char[word.length()];
			for (int i = 0; i < word.length(); i++){
				char a =  word.toLowerCase().charAt(i);
				letters[i] = a;;
			}
			ArrayList<String> anagramList = createAnagram(letters);
			anagrams.put(word, anagramList);
		}
	}
	static ArrayList<String> createAnagram(char[] a) {
		ArrayList<String> ret = new ArrayList<String>();
	    permutation(a, 0, ret);
	    return ret;
	}

	public static void permutation(char[] arr, int pos, ArrayList<String> list){
	    if(arr.length - pos == 1){
	    	String newWord = String.valueOf(arr.clone());
	        if (!list.contains(newWord)) list.add(newWord);
	    }
	    else
	        for(int i = pos; i < arr.length; i++){
	            swap(arr, pos, i);
	            permutation(arr, pos+1, list);
	            swap(arr, pos, i);
	        }
	}

	public static void swap(char[] arr, int pos1, int pos2){
	    char h = arr[pos1];
	    arr[pos1] = arr[pos2];
	    arr[pos2] = h;
	}

	

}
