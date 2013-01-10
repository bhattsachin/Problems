package com.bhatt.gap;


/**
 * Parses sentence into words
 * @author bhatt
 *
 */
public class Parser {
	
	public static final String SPACE = " ";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sentence = "I wish I may I wish I might";
		Parser parser = new Parser();
		String[] words = parser.parse(sentence);
		for(String word: words){
			System.out.println(word);
		}
	}
	
	/**
	 * add more parsing rules here
	 * @param sentence
	 * @return
	 */
	public String[] parse(String sentence){
		String[] words = sentence.split(SPACE);
		return words;
	}
	
	

}
