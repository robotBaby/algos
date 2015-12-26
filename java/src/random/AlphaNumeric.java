package random;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphaNumeric {
	
	public static void main(String...args){
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		int value = 2;
		int incrementer = 0;
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++){
			dict.put(String.valueOf(alphabet), value);
			incrementer++;
			if (incrementer == 3){
				if (value == 9 || value == 7) continue;
				else {
				value++;
				incrementer = 0;
				}
			} else if (incrementer == 4){
				value++;
				incrementer = 0;
				}
		}
		System.out.println(dict);
		String alpha = "(1-800-COM-CAST)";
		String pattern = "\\(|\\-|\\)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(alpha);
		alpha = m.replaceAll("");
		
		String result = "";
		for (int i = 0; i < alpha.length(); i++){
			String thisChar = alpha.substring(i, i+1);
			try {
				result += Integer.parseInt(thisChar);
			} catch (Exception e) {
				result += dict.get(thisChar);
			} 
		}
		System.out.println(result);
	}

}
