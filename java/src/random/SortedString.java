package random;

public class SortedString {
	
	public static void main(String...args){
		String[] stringList = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};		
		int index = searchString(stringList, "ball", 0, stringList.length-1);
		System.out.println(index);
		
	}

	private static int searchString(String[] stringList, String string, int l, int u) {
		int index = -1;
		int m = (l+u) /2;
		if (stringList[m].equals(string)) index = m;
		else {
			int i = m;
			int j = m;
			while(stringList[i].equals("") && i < u){
				i++;
			}
			while(stringList[j].equals("") && j > l){
				j--;
			}
			
			if (stringList[i].compareToIgnoreCase(string) < 0){
				index = searchString(stringList, string, i, u);
			}
			if (stringList[i].equals(string)){
				index = i;
			}
			else if (stringList[j].compareToIgnoreCase(string) > 0){
				index = searchString(stringList, string, l, j);
			}
			else if (stringList[j].equals(string)){
				index = j;
			}
		}
		
		return index;
	}

}
