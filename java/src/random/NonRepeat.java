package random;

import java.util.HashMap;

public class NonRepeat {
	
	public static void main(String...args){
		HashMap<Character, Integer> mytable = new HashMap<Character, Integer>();
		int nr = 0;
		String stream = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbb";
		for (int i = 0; i < stream.length(); i++){
			if (!mytable.containsKey(stream.charAt(i))) {
				nr++;
				if (nr == 2) System.out.println(stream.charAt(i));
				mytable.put(stream.charAt(i), 0);
			}
			mytable.put(stream.charAt(i), mytable.get(stream.charAt(i)) + 1) ;
		}
		
	}

}
