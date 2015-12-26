package practise;

public class HashTable<T1, T2> {
	
	KeyValue<T1, T2>[] table;
	public HashTable(int tableSize){
		table = new KeyValue[tableSize];
	}
	
	public Object get(T1 key){
		int hash = key.hashCode() % table.length;
		while(table[hash] != null && table[hash].getKey() != key){
			hash = (hash + 1) % table.length; 
		}
		if (table[hash] == null) return null;
		else return table[hash].getValue();
	}
	
	public void put(T1 key, T2 value){
		int hash = key.hashCode() % table.length;
		while(table[hash] != null && table[hash].getKey() != key){
			hash = (hash + 1) % table.length; 
		}
		table[hash] = new KeyValue<T1, T2>(key, value);
	}

}
