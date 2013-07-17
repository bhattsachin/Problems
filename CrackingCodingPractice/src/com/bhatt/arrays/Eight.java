package com.bhatt.arrays;

/**
 * 
 * @author bhatt If a String is rotation of other
 */
public class Eight {
	/**
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isRotation(String source, String target) {
		StringBuffer sb = new StringBuffer(target + target + target);
		return isSubSequence(sb.toString(), source);
	}

	public static boolean isSubSequence(String a, String b) {
		return a.contains(b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String one = "waterbottle";
		String two = "erbottlewat";
		System.out.println("is" + one + " substring of " + two + " "
				+ isRotation(one, two));
	}

}
