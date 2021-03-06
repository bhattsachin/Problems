package com.bhatt.arrays;

/**
 * 
 * @author bhatt 
 * Replace spaces by '%20'
 * Wondering if we can have an inplace implementation of this and if so will that be efficient
 */
public class Five {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String replaceSpace(String input) {
		char[] inputarray = input.toCharArray();
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < inputarray.length; i++) {
			if (inputarray[i] != ' ') {
				output.append(inputarray[i]);
			} else {
				output.append("%20");
			}
		}

		return output.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abc def gh";
		System.out.println(input + " after replacing spaces: "
				+ replaceSpace(input));
	}

}
