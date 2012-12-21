package com.bhatt.arrays;

/**
 * @author bhatt Find if anagram
 */
public class Four {

	/**
	 * @param input
	 * @return
	 */
	public static boolean isAnagram(String input) {
		char[] inputarray = input.toCharArray();
		int len = inputarray.length;
		boolean anagram = true;
		for (int i = 0; i < (len / 2); i++) {
			if (inputarray[i] != inputarray[len - 1 - i]) {
				anagram = false;
				break;
			}
		}

		return anagram;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "malayalam";
		System.out.println("Is " + input + " an anagram: " + isAnagram(input));

		input = "monalisa";
		System.out.println("Is " + input + " an anagram: " + isAnagram(input));
	}

}
