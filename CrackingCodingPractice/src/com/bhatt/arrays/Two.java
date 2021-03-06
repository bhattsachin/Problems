package com.bhatt.arrays;

/**
 * 
 * @author bhatt Reverse a String C-Style
 */
public class Two {

	/**
	 * dumb implementation
	 * @param input
	 * @return
	 */
	public static String reverseString(String input) {
		int len = input.length();
		char[] reverse = new char[len];
		char[] inputarray = input.toCharArray();
		for (int i = 0; i < len; i++) {
			reverse[(len - 1) - i] = inputarray[i];
		}
		return String.valueOf(reverse);
	}
	
	/**
	 * In place implementation
	 * @param input
	 * @return
	 */
	public static String reverseStringInPlace(String input){
		int len = input.length();
		char[] inputarray = input.toCharArray();
		char tmp;
		for(int i=0; i<(len/2);i++){
			tmp = inputarray[i];
			inputarray[i] = inputarray[len-1-i];
			inputarray[len-1-i] = tmp;
		}
		
		return String.valueOf(inputarray);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "vascodigama";
		System.out.println("Reverse of : " + input + " is : "
				+ reverseString(input));
		
		System.out.println("Reverse of : " + input + " is : "
				+ reverseStringInPlace(input));
		input = "vasque";
		System.out.println("Reverse of : " + input + " is : "
				+ reverseStringInPlace(input));

	}

}
