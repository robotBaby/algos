package practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Hashmap {

	
	public static void main(String...args){
		HashMap<Key, Key> phoneMap = new HashMap<Key, Key>();
		Key k1 = new Key("Arindrima", "Datta", "6465153234", "working");
		phoneMap.put(k1, k1);
		k1 = new Key("Arindrima", "Datta", "6465153234", "working");
		phoneMap.put(k1, k1);
		k1 = new Key("Anup", "Datta", "9831037705", "working");
		phoneMap.put(k1, k1);
		k1 = new Key("Rita", "Datta", "9433323472", "working");
		phoneMap.put(k1, k1);
		k1 = new Key("Jyotirmoy", "Mandal", "6465153234", "student");
		
		String r = lookup("Arindrima", "firstname", phoneMap);
		
		System.out.println(r);
		HashTable<String, String> nh = new HashTable<String, String>(128);
		nh.put("Arin", "Hello");
		nh.put("Josh", "Hello again");
		nh.put("Josh", "Rewriting");
		System.out.println(nh.get("Arin"));;
	}

	private static String lookup(String value, String variable, HashMap<Key, Key> phoneMap) {
		Iterator<Entry<Key, Key>> it = phoneMap.entrySet().iterator();
		String r = "The variable " + variable + " with value " + value + " does not exist in in the phone map";;
		while(it.hasNext()){
			Key k = it.next().getKey();
			Key r_k = k.lookup(value, variable);
			if (r_k != null) r= (r_k.firstname + " " + r_k.lastname + " " + r_k.number + " " + r_k.designation);
		}
		
		return r;
	}
	
	
}
