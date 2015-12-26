package practise;

public class BitWise {

	public static void main(String...args){
//		bitwise_add(5,6);
//		bitwise_subtract(5,6);
//		bitwise_multiply(5,12);
//		setBit(5, 1, false);
//		is_less_than(5,5000);
//		smallest_largest_samebit(6);
		System.out.println(Integer.toBinaryString(~(1 << 2)));
	}

	private static void smallest_largest_samebit(int i) {

		int zero_pos = 0;
		int one_pos = 0;
		int temp1 = i;
		while(temp1 !=0){
			if ((temp1&1) ==0) break;
			else temp1 = temp1>>1;
			zero_pos++;
		}
		int temp2 = i;
		while(temp2 !=0){
			if ((temp2&1) ==1) break;
			else temp2 = temp2>>1;
			one_pos++;
		}
		
		int smallest_int = setBit(i, one_pos, false);
		smallest_int = setBit(i, zero_pos, true);
		int largest_int = setBit(i, one_pos, false);
		largest_int = setBit(i, zero_pos, true);	

	}

	private static void is_less_than(int i, int j) {
		int com= ((i-j)>>31)&1;
		System.out.println(com);
	}

	private static int setBit(int i, int digit, boolean val) {
		System.out.println(Integer.toBinaryString(i));
		int present = (i >>(digit-1)) & 1;
		int toset =0;
		int result = i;
		if (val) toset = 1;
		if (present == 0) result = (i | (toset << (digit -1)));
		else {
			if (toset == 0) result = (i ^ (1 << (digit -1)));
		}
		System.out.println(Integer.toBinaryString(result));
		return result;
	}

	private static void bitwise_multiply(int i, int j) {
		int product = 0;
		while(j != 0){
			if ((j&1) != 0) product = product +i;
			i = i<<1;
			j= j>>1;
		}
		System.out.println(product);
	}

	private static void bitwise_subtract(int i, int j) {
		int sum = i;
		int temp = -j;
		while(temp !=0 ){
			int carried = sum&temp;
			sum = sum^temp;
			temp = carried<<1;
		}

		System.out.println(sum);		
	}

	private static void bitwise_add(int i, int j) {

		while(j !=0 ){
			int carried = i&j;
			i = i^j;
			j = carried<<1;
		}

		System.out.println(i);	

	}
}
