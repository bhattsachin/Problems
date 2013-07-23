package com.bhatt.binary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DecimalToBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        System.out.println(toBinary(line));
	       
	    }
		}catch(Exception ex){
			System.out.println("Parsing erro:" + ex.getMessage());
		}

	}

	public static String toBinary(String input) {
		StringBuilder sb = new StringBuilder();
		try {
			int number = Integer.parseInt(input);
			if (number < 0)
				return "Input error:";
			int remainder;
			while (number / 2 > 0) {
				remainder = number % 2;
				number = number / 2;
				sb.append(remainder);
			}

			sb.append(number);

			return sb.reverse().toString();

		} catch (NumberFormatException ex) {
			// System.out.println("Input error: " + ex.getMessage());
		}

		return "Input error:";
	}

}
