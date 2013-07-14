package com.bhatt.mccoy;


public class ReplaceBinary {
	
	BinaryWord source;
	BinaryWord destination;
	
	private ReplaceBinary(){}
	
	public static ReplaceBinary valueOf(String source, String destination){
		
		ReplaceBinary repbin = new ReplaceBinary();
		repbin.source = BinaryWord.valueOf(source);
		repbin.destination = BinaryWord.valueOf(destination);
		
		return repbin;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
