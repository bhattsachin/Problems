package com.bhatt.unique;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NoDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        printUnique(line);
	    }
		}catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

	public static void printUnique(String input) {
		String[] nums = input.split(",");
		if (nums.length >= 0) {
			int[] inums = new int[nums.length];
			int i = 0;
			boolean anythingPresent = false;
			for (String inp : nums) {
				if (inp.length() > 0) {
					inums[i++] = Integer.parseInt(inp);
					anythingPresent = true;
				}

			}

			int prev = inums[0];
			boolean first = true;
			if (anythingPresent) {
				for (int num : inums) {

					if (num != prev || first) {
						System.out.print(first ? num : "," + num);
						first = false;
						prev = num;
					}
				}
				System.out.print("\n");
			}
		}

	}

}
