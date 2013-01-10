package com.bhatt.gap;

import java.util.Arrays;
import java.util.List;

/**
 * @author bhatt
 *
 */
public class Utils {
	
	/**
	 * 
	 * @param data
	 * @param seperator
	 * @return
	 */
	public static String printArray(List<String> data, String seperator){
		StringBuffer buf = new StringBuffer();
		boolean more = false;
		String split = "";
		for(String word : data){
			buf = buf.append(split + word);
			if(!more){
				split = seperator;
				more = true;
			}
		}
		
		return buf.toString();
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static String getRandomItemFromArray(String[] list){
		String word = null;
		if(list!=null & list.length>0){
			int size = list.length;
			int randomArrayIdx = (int)(Math.random()*size);
			word = list[randomArrayIdx];
		}
		
		return word;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static String printArrayWithComma(List<String> data){
		return printArray(data, ", ");
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static String printArrayWithSpace(List<String> data){
		return printArray(data, " ");
	}
	
	public static void main(String args[]){
		String[] words = {"abc", "def", "tom", "jerry", "I", "might"};
		System.out.println(getRandomItemFromArray(words));
		
	}
	
	public static String[] toStringArray(Object[] inpArray){
		return Arrays.copyOf(inpArray,inpArray.length,String[].class);
	}

}
