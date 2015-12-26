package practise;

public class BitManipulation {
	
	public static void main(String...args){
		
		double Number = 6.625;
		int N = (int) Number;
		double d = Number - N;
		String result = "";
		while(N != 0){	
			int r = (int) N % 2;
			N = (int) N / 2;
			result += r;
		}

		String result_final = new StringBuffer(result).reverse().toString();
		result_final += ".";
		int f = 0;
		while(d != 0){
			d = d*2;
			f = (int) d;
			d -= f;
			result_final += Integer.toString(f);
		}
		System.out.println(result_final);
		String alternate = printBinary("6.625");
		System.out.println(alternate);

	}
	
	public static void oddEvenSwap(){
		int x = 8;
		String binary = "";
		while(x !=0){
			int odd = x & 1;
			x >>= 1;
			int even = (x & 1);
			binary += Integer.toString(even);
			binary += Integer.toString(odd);
			x >>= 1;
		}
		String final_string = "";
		for (int i = binary.length() -1 ; i >= 0; i--){
			final_string += binary.charAt(i);
		}
		System.out.println(final_string);
	}
	public static void xor(){
		int n = 32;
		int m = 14;
		int x = m ^ n;
		int k = 0;
		while(x != 0){
			x >>= 1;
			k += x & 1;
		}
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(k);
	}
	
	public static void printBinaryMine(){

		double Number = 6.72;
		int N = (int) Number;
		double d = Number - N;
		String result = "";
		while(N != 0){	
			int r = (int) N % 2;
			N = (int) N / 2;
			result += r;
		}
		String result_final = "";
		for (int i = result.length() -1; i >-1; i--){
			result_final += result.charAt(i);
		}
		result_final += ".";
		int f = 0;
		while(d != 0){
			d = d*2;
			f = (int) d;
			d -= f;
			result_final += Integer.toString(f);
		}
		System.out.println(result_final);
		String alternate = printBinary("6.625");
		System.out.println(alternate);
	}
	
	public static String printBinary(String n) {
		 int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		 double decPart = Double.parseDouble(
		 n.substring(n.indexOf('.'), n.length()));
		 String int_string = "";
		 while (intPart > 0) {
		 int r = intPart % 2;
		 intPart >>= 1;
		 int_string = r + int_string;
		 }
		 StringBuffer dec_string = new StringBuffer();
		 while (decPart > 0) {
		 if (dec_string.length() > 32) return "ERROR";
		 if (decPart == 1) {
		 dec_string.append((int)decPart);
		 break;
		 }
		 double r = decPart * 2;
		 if (r >= 1) {
		 dec_string.append(1);
		 decPart = r - 1;
		 } else {
		 dec_string.append(0);
		 decPart = r;
		 }
		 }
		 return int_string + "." + dec_string.toString();
		 }
	
	public static void BitHandling(){
		int i = 2;
		int j = 6;
		int N = Integer.parseInt("10000001100", 2);
		int M = Integer.parseInt("10101", 2);
		
		int max = ~0;
		int left = max - ((1<<j) -1) ;
		int right = (1<<i) -1;
		int mask = left | right;
		System.out.println("max :" + Integer.toBinaryString(max));
		System.out.println("left :" + Integer.toBinaryString(left));
		System.out.println("right :" + Integer.toBinaryString(right));
		System.out.println("mask :" + Integer.toBinaryString(mask));
		int result = (N & mask) | (M << i);

		System.out.println("N :" + Integer.toBinaryString(N));
		System.out.println("M: " + Integer.toBinaryString(M));
		System.out.println("Result :" + Integer.toBinaryString(result));
	}

}
