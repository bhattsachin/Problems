package com.bhatt.longestlines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PassTriangle {

	static int idx;
	static long num;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    int[] inp;
	    long base = 0;
	    while ((line = in.readLine()) != null) {
	        String[] lineArray = line.split(" ");
	        if (lineArray.length > 0) {
	            inp = new int[lineArray.length];
	            for(int k=0;k<lineArray.length;k++){
	            	inp[k] = Integer.parseInt(lineArray[k]);
	            }
	            base = sumMaxFromArray(base, inp);
	        }
	    }
	    System.out.println(base);
	    //System.out.println(num);
		}catch(Exception ex){
			System.out.println("INPUT ERROR : " + ex.getMessage());
		}
		
		

	}
	
	private static long  sumMaxFromArray(long base, int[] array){
		int nIdx = idx;
		int max = -1;
		
		if(array.length>(idx+1))
			nIdx = (array[idx]>array[idx+1])?idx:idx+1;
		
		max = array[nIdx];
		idx = nIdx;
		for(int k : array){
			if(k==array[nIdx]){
				System.out.print(" _" + k);
			}else{
				System.out.print(" " + k);
			}
		}
		System.out.println("");
		num = num + max;
		return (base + max);
	}

}
