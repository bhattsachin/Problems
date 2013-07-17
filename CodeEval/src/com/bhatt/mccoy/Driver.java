package com.bhatt.mccoy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {
	
	BinaryWord word;
	List<ReplaceBinary> findReplace;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
		File file = new File(args[0]);
		try{
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
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
		}catch(IOException ex){
			ex.printStackTrace();
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
