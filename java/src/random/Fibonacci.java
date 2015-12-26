package random;

public class Fibonacci {

	

	
	public static void main(String...args){
		int f_0 = 0;
		int f_1 = 1;
		fibonacci(f_0, f_1);
	
	}

	private static void fibonacci(int f_0, int f_1) {

		System.out.println(f_0);
		System.out.println(f_1);
		int count = 0;
		while(count < 10){
			int fn = f_0 + f_1;
			System.out.println(fn);
			f_0 = f_1;
			f_1 = fn;
			count++;
		}
	}
}
