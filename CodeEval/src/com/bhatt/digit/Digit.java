package com.bhatt.digit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Digit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        String[] lineArray = line.split(";");
	        
	        if (lineArray.length > 0) {
	           for(String item : lineArray){
	        	   if(item.length()>2)
	        		   System.out.print(convertToNum(item));
	           }
	        	   
	        }
	        System.out.println();
	    }
		}catch(Exception ex){
			System.out.println("error" + ex.getMessage());
		}

	}

	public static int convertToNum(String input) {

		char[] data = input.toLowerCase().toCharArray();

		switch (data[0]) {
		case 'z':
			return 0;
		case 'o':
			return 1;
		case 'e':
			return 8;
		case 'n':
			return 9;
		case 'f':
			if (data[1] == 'o')
				return 4;
			else if (data[1] == 'i')
				return 5;
			break;
		case 't':
			if (data[1] == 'w')
				return 2;
			else if (data[1] == 'h')
				return 3;
			break;
		case 's':
			if (data[1] == 'i')
				return 6;
			else if (data[1] == 'e')
				return 7;
			break;

		default:
		}

		return -1;
	}

}
