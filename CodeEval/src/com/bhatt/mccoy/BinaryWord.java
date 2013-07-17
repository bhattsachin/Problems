package com.bhatt.mccoy;

import java.util.LinkedList;
import java.util.List;

public class BinaryWord {

	List<Binary> word = new LinkedList<Binary>();
	
	private BinaryWord(){
		
	}
	
	public static BinaryWord valueOf(String txt){
		BinaryWord wd = new BinaryWord();
		char[] inp = txt.toCharArray();
		for(int i=0;i<inp.length;i++){
			wd.word.add(Binary.valueOf(inp[i]));
		}
		
		return wd;
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Binary bin : word){
			sb.append(bin.digit.getVal());
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
