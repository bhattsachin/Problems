package com.submit.mccoy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Main {

	BinaryWord word;
	List<ReplaceBinary> findReplace;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main driver = new Main();
		
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	    	System.out.println(">" + line);
	        String[] lineArray = line.split(";");
	        String[] replaceArray;
	        if (lineArray.length > 0) {
	            //System.out.println(lineArray[0]);
	            //base value
	            driver.word = BinaryWord.valueOf(lineArray[0]);
	            driver.findReplace = new ArrayList<ReplaceBinary>();
	            
	            //System.out.println(lineArray[1]);
	            replaceArray = lineArray[1].split(",");
	            for(int i=0;i<replaceArray.length;i=i+2){
	            	driver.findReplace.add(ReplaceBinary.valueOf(replaceArray[i], replaceArray[i+1]));
	            }
	            
	            //now all find replace items have been added. lets start matching.
	            for(ReplaceBinary repbin : driver.findReplace){
	            	driver.findReplace(driver.word, repbin.source, repbin.destination);
	            }
	            
	            System.out.println(driver.word);
	        }
	    }
		}catch(Exception ex){
			System.out.println("INVALID input" + ex.getMessage());
		}

	}
	
	private void findReplace(BinaryWord base, BinaryWord find, BinaryWord replace){
		boolean match = false;
		int index = 0;
		int sizeToIterate = base.word.size()-find.word.size()+1;
		for(int i=0;i<sizeToIterate;i++){
			match = false;
			
			for(int j=0;j<find.word.size();j++){
				
				if((base.word.get(i+j).digit==find.word.get(j).digit) && base.word.get(i+j).old==Boolean.TRUE){
					//match found
					match = true;
				}else{
					match = false;
					break;
				}
			}
			
			if(match){
				break; //lets break this loop and do changes in list and run this again
			}
			index+=1;
			
			
		}
		
		
		if(match){
			//modify here
			for(Binary bin : find.word){
				base.word.remove(index); //removes that many number of elements
			}
			
			for(Binary bin : replace.word){
				base.word.add(index, Binary.valueOf(bin));
			}
			
			//call it recursively
			findReplace(base, find, replace);
			
		}
		
		
		
	}


}


class Binary {

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
class BinaryWord {

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

class ReplaceBinary {
	
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

