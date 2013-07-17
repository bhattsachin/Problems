package com.submit.square;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	List<Long> squares = new ArrayList<Long>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main sq = new Main();
		sq.initStuff();
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    boolean isMeta = true;
	    int currCount = 0;
	    int totalCount = 0;
	    while ((line = in.readLine()) != null) {
	        if(isMeta){
	        	totalCount = Integer.parseInt(line);
	        	currCount = 0;
	        	isMeta = false;
	        }else{
	        	currCount+=1;
	        	System.out.println(sq.getSquareCount(Long.parseLong(line)));
	        	
	        }
	        
	        if(currCount==totalCount){
	        	isMeta = true;
	        }
	        
	    }
	    
		}catch(Exception ex){
			System.out.println("Some exception" + ex.getMessage());
		}
		
		

	}

	private int getSquareCount(Long val) {
		int count = 0;
		Long remainder = null;
		Set<Long> alreadyFound = new HashSet<Long>();
		for (Long bval : squares) {
			if (bval.compareTo(val) > 0)
				break; // if already beyond that value

			if (!alreadyFound.contains(bval)) {
				remainder = val - bval;

				if (squares.contains(remainder)) {
					count += 1;
					alreadyFound.add(bval);
					alreadyFound.add(remainder);
				}
			}

		}

		return count;
	}

	private void initStuff() {
		for (int a = 0; a < 46343; a++) {
			squares.add(Long.valueOf(a * a));
		}

	}

}
