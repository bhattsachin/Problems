package com.bhatt.gap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates index/hashtable entry
 * @author bhatt
 *
 */
public class Indexer {
	
	public static String last2Word = null;
	public static String last1Word = null;
	public static Map<String, List<String>> index = new HashMap<String, List<String>>();
	public static String SPLITTER = "_";

	
	/**
	 * Creates index. Can be saved to backend store/db in case this is going to be huge.
	 * @param words
	 */
	public void index(String[] words){
		for(String word: words){
			//last two words were keys and this is next word in sequence
			if(last2Word!=null && last1Word!=null){
				//add current word as value of above 2 keys
				add(last2Word, last1Word, word);
			}
			
			//last word and current word - waiting for next word as value
			if(last1Word!=null){
				last2Word = last1Word;
				last1Word = word;
				
			}else{
				//current word and next two words 
				last1Word = word;
			}
			
		}
	}
	
	/**
	 * add to index
	 * @param key1
	 * @param key2
	 * @param value
	 */
	public void add(String key1, String key2, String value){
		
		if(key1!=null && key2!=null && value!=null){
			String key = key1 + SPLITTER + key2;
			List<String> values = index.get(key);
			if(values==null){
				values = new ArrayList<String>();
			}
			values.add(value);
			index.put(key, values);
			
		}
	}
	
	/**
	 * 
	 * @return random key of index
	 */
	public String[] getRandomStartingPoint(){
		Object[] tkeys = index.keySet().toArray();
		String[] keys = Utils.toStringArray(tkeys);
		String key = Utils.getRandomItemFromArray((String[])keys);
		String[] words = key.split(SPLITTER);
		
		return words;
	}
	
	/**
	 * Returns next word from index else returns null
	 * @param key1
	 * @param key2
	 * @return
	 */
	public String getNextWord(String key1, String key2){
		String word = null;
		List<String> value = null;
		String key = null;
		//TODO: also do empty check here and during training part
		if(key1!=null && key2!=null){
			key = key1 + SPLITTER + key2;
			value = index.get(key);
			if(value==null) return word;
			word = Utils.getRandomItemFromArray(Utils.toStringArray(value.toArray()));
		}
		
		return word;
	}


}
