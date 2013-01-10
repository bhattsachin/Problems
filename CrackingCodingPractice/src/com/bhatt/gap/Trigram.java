package com.bhatt.gap;

import java.util.List;

/**
 * Read String
 * Parse remove punctuations before and after
 * create index/hash
 * 
 * @author bhatt
 *
 */
public class Trigram {
	
	private Parser parser = new Parser();
	private Indexer indexer = new Indexer();
	private Generator generator = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trigram trigram = new Trigram();
		trigram.train("I wish I may I wish I might");
		System.out.println("----- Printing Index -------");
		trigram.printIndex();
		System.out.println("----- Printing Story -------");
		trigram.printStory(500);

	}
	
	/**
	 * This can be called multiple times depending on story length and buffer size used
	 * @param sentence
	 */
	public void train(String sentence){
		String[] words = parser.parse(sentence);
		indexer.index(words);
		
	}
	
	public void printIndex(){
		for(String key: indexer.index.keySet()){
			System.out.println(key + " >> " + Utils.printArrayWithComma(indexer.index.get(key)));
		}
	}
	
	/**
	 * 
	 * @param limit
	 */
	public void printStory(int limit){
		generator = new Generator(indexer);
		List<String> story = generator.generate(limit);
		System.out.println(Utils.printArrayWithSpace(story));
	}

}
