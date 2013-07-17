package com.bhatt.gap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads from different sources
 * @author bhatt
 *
 */
public class StoryReader {
	
	private Indexer indexer = null;
	
	public StoryReader(Indexer indexer){
		this.indexer = indexer;
	}
	
	
	public void readFromTxtFile(String filename)throws IOException{
		BufferedReader reader = null;
		try {
			FileInputStream fstream = new FileInputStream(filename);
			InputStreamReader in = new InputStreamReader(fstream);
		    reader = new BufferedReader(in);
			String line = null;
			String[] words;
			while ((line = reader.readLine()) != null) {
				words = Parser.parse(line);
				indexer.index(words);
				
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
