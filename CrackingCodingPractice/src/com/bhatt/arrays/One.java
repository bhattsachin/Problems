package com.bhatt.arrays;

/**
 * @author bhatt 
 * if a string has all unique characters
 */

public class One {

	//DS to hold count of all 256 ascii values
	static int[] hash = new int[256];

	public static void main(String args[]) {
		String input = "han135mod";
		System.out.println(input + " has unique characters: " + hasUnique(input));
	}

	/**
	 * finds whether or not input contians unique characters
	 * @param input
	 * @return
	 */
	public static boolean hasUnique(String input) {
		int ascii = 0;
		boolean unique = true;
		for (char i : input.toCharArray()) {
			ascii = i;
			if (hash[ascii] != 0) {
				// already exists
				unique = false;
				break;
			} else {
				hash[ascii] = hash[ascii] + 1;
			}
		}
		return unique;
	}

}
