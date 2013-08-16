package bits;


public class Bits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int val = 'e' - 'a';
		System.out.println(val);
		System.out.println(Integer.toBinaryString(1 << val));
		
		System.out.println("get bits");
		System.out.println(getBit(4, 2));
		System.out.println(Integer.toBinaryString(31));
		System.out.println(Integer.toBinaryString(14));
		System.out.println(Integer.toBinaryString(14 & 31));
		xor(14,31);

	}
	
	public static boolean getBit(int num, int pos){
		System.out.println(num + " - " + Integer.toBinaryString(num));
		return ((num & (1<< pos))!=0);
	}
	
	public static void xor(int a, int b){
		int count=0;
		for(int c=a^b;c>0;c=c-1){
			count+=((c>>1)==1)?1:0;
		}
		System.out.println(count);
	}

}
