package com.bhatt.mccoy;

public class Binary {

	ONEZERO digit;
	Boolean old;
	
	private Binary(){
		
	}
	
	public static Binary valueOf(char a){
		Binary bin = new Binary();
		bin.digit = ONEZERO.getValue(a);
		bin.old = Boolean.TRUE;
		return bin;
	}
	
	public static Binary valueOf(Binary binO){
		
		Binary bin = new Binary();
		bin.digit = binO.digit;
		bin.old = Boolean.FALSE;
		return bin;
	}
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

enum ONEZERO{
	ONE(1), ZERO(0), UNDEF(-1);
	private final int val;

	private ONEZERO(int i){
		val = i;
	}
	public int getVal(){
		return val;
	}
	public static ONEZERO getValue(char str){
		if(str == '1')
			return ONEZERO.ONE;
		else if(str == '0')
			return ONEZERO.ZERO;
		
		return ONEZERO.UNDEF;
	}
	
	
	
	
}
