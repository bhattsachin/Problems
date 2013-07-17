package com.bhatt.gap;

import java.io.IOException;
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
	
	private Indexer indexer = new Indexer();
	private Generator generator = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trigram trigram = new Trigram();
		trigram.trainFromFile("/Users/bhatt/Documents/Practice/CrackingCodingPractice/src/Carol.txt"); //FIXME: use relative path
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
		String[] words = Parser.parse(sentence);
		indexer.index(words);
		
	}
	
	public void trainFromFile(String filename){
		StoryReader reader = new StoryReader(indexer);
		try{
		reader.readFromTxtFile(filename);
		}catch(IOException ex){
			ex.printStackTrace();
			System.out.println("ERROR READING FILE");
			System.exit(1);
		}
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
