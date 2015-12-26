package practise;

public class KeyValue<T1, T2> {
	
	T1 key;
	T2 value;
	KeyValue(T1 key, T2 value){
		this.key = key;
		this.value = value;
	}
	
	public T1 getKey(){
		return key;
	}
	public T2 getValue(){
		return value;
	}

}
