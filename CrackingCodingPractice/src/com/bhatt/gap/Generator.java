package com.bhatt.gap;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Story
 * @author bhatt
 *
 */
public class Generator {
	
	private Indexer indexer;
	
	public Generator(Indexer indexer){
		this.indexer = indexer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Size of story is limited by memory and hence input limit must be checked against
	 * @param limit
	 * @return
	 */
	public List<String> generate(int limit){
		
		//upper limit. configure
		if(limit>500000) return null;
		
		List<String> story = new ArrayList<String>();
		String[] firstTwoWords = indexer.getRandomStartingPoint();
		
		//TODO:check if it has both 2 words in it and valid
		String firstWord = firstTwoWords[0];
		String secondWord = firstTwoWords[1];
		story.add(firstWord);
		story.add(secondWord);
		int count = 2;
		String lastWord = secondWord;
		String tmpWord;
		
		String word = indexer.getNextWord(firstWord, secondWord);
		while(count<limit && word!=null){
			story.add(word);
			count++;
			tmpWord = word;
			word = indexer.getNextWord(lastWord, word);
			lastWord = tmpWord;
		}
		
		return story;
		
	}

}
