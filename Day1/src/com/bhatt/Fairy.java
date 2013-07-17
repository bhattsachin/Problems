package com.bhatt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fairy {
	public static List<String> BINARY_VALUES = new ArrayList<String>();
	public static int[] BINARY = new int[21];
	static{
		BINARY_VALUES.add("1");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger val=BigInteger.valueOf(1);
		for(int i=0;i<=20;i++){
			val = BigInteger.valueOf(1);
			for(int k=0;k<=i;k++){
				val = val.multiply(BigInteger.valueOf(5));
			}
			System.out.print(val);
			BINARY_VALUES.add(val.toString(2));
			
			System.out.println(" -- " + val.toString(2).length());
		}
		
		

	}

}
