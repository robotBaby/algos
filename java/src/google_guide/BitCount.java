package google_guide;

public class BitCount {
	
	public int bitCount(int value) {
	    int count = 0;
	    while (value > 0) {           // until all bits are zero
	        if ((value & 1) == 1)     // check lower bit
	            count++;
	        value >>= 1;              // shift bits, removing lower bit
	    }
	    return count;
	}
	
	public int bitCount2(int value) {
		int count = 0;
		int q = Integer.MAX_VALUE;
		int r = 0;
		while(q > 0) {
			q = value % 2;
			r = value / 2;
			if (r == 1) count++;
			value = q;
		}
		
		return count;
	}

}
