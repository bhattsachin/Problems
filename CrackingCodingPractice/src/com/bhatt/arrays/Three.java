package com.bhatt.arrays;

/**
 * @author bhatt Remove duplicates from a given string
 */
public class Three {

	// DS to hold count of all 256 ascii values
	static int[] hash = new int[256];

	/**
	 * remove duplicates inplace
	 * @param input
	 * @return
	 */
	public static String removeDuplicates(String input) {
		char[] inputarray = input.toCharArray();
		int len = inputarray.length;
		int ascii;
		int oldincr = 0, newincr = 0;
		for (int i = 0; i < len; i++) {
			ascii = inputarray[i];
			if (hash[ascii] == 0) {
				hash[ascii] = hash[ascii] + 1;
				inputarray[newincr] = inputarray[oldincr];
				newincr++;
			}
			oldincr++;
		}
		// blackout remaining chars
		for (int k = newincr; k < len; k++) {
			inputarray[k] = ' '; // or we should truncate this string
		}

		return String.valueOf(inputarray);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "burjjjkhhalillfa";
		System.out.println(input + " after removing duplicates: "
				+ removeDuplicates(input));

	}

}
