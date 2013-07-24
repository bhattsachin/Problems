package com.bhatt.jolly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JollyJumpers {

	public static void isJolly(int[] numbers) {
		int size = numbers.length;
		// difference should always be less than this number
		int diff;
		boolean isJolly = false;
		boolean[] isCovered = new boolean[size-1];
		int i;
		for (i = 1; i < size; i++) {
			diff = Math.abs(numbers[i - 1] - numbers[i]);
			if (diff >= size || diff < 1) {
				break;
			}
			if (isCovered[diff-1] == true)
				break; // if the numbers repeat they can't cover all of them
			isCovered[diff-1] = true;

			//System.out.print(diff);
		}
		
		boolean coveredAll = true;

		// does it covered all the spaces
		for(boolean cover: isCovered){
			if(cover == false){
				coveredAll = false;
				break;
			}
		}
		
		if(i>=size-1 && coveredAll){
			isJolly = true;
		}

		System.out.println(isJolly ? "Jolly" : "Not jolly");

		//System.out.println("\n" + size);
	}
	
	
	public static int[] parseNumbers(String line){
		String[] items = line.split(" ");
		int[] numbers = new int[items.length];
		int i=0;
		for(String item : items){
			numbers[i++] = Integer.parseInt(item);
		}
		
		
		
		return numbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        isJolly(parseNumbers(line));
	    }
		}catch(Exception ex){
			System.out.println("FILE Error: " + ex.getMessage());
		}

		//isJolly(new int[] { 1, 4, 2, 3});
		//System.out.println(Arrays.toString(parseNumbers("4 56 7 8")));

	}

}
