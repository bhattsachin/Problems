package com.bhatt.filelength;

import java.io.File;

public class FileSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		
	        File realFile = new File(args[0]);
	        System.out.println(realFile.length());
	    
	    
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}

	}

}
