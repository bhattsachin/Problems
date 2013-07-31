package com.bhatt.longestlines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LongestLines {
	
	static Input[] datastore;
	static int N;
	static int CountSoFar;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			try{
		    File file = new File(args[0]);
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    boolean first = true;
		    while ((line = in.readLine()) != null) {
		    	if(first){
		    		first = false;
		    		new LongestLines(Integer.parseInt(line));
		    		if(Integer.parseInt(line)<1) return;
		    	}else{
		    		printLongestLines(line);
		    	}
		       
		    }
		    
		    for(int i=0;i<N;i++){
		    	System.out.println(datastore[i]);
		    }
		    
			}catch(Exception ex){
				ex.printStackTrace();
			}

	}
	
	public LongestLines(int i){
		datastore = new Input[i];
		this.N = i;
	}
	
	
	private static void printLongestLines(String text){
		StringBuffer sb = new StringBuffer(text.trim());
		if(sb.length()>1){
			addToStore(new Input(sb.toString()));
		}
		
	}
	
	private static void addToStore(Input inp){
		
		if(CountSoFar<N){
			addPre(inp);
			return;
		}
		
		Input itm;
		
		if(datastore[N-1].len>inp.len) return;
		
		for(int i=0;i<N-1;i++){
			itm = datastore[i];
			if(itm.len<inp.len){
				addAfter(i-1, inp);
			}
		}
		//addAfter(-1,inp);
	}
	
	private static void addAfter(int k, Input inp){
		for(int i=N-1;i>k+1;i--){
			datastore[i] = datastore[i-1];
		}
		datastore[k+1] = inp;
	}
	
	private static void addPre(Input inp){
		Input itm;
		for(int i=0;i<CountSoFar;i++){
			if(datastore[i].len<inp.len){
				itm = datastore[i];
				
				for(int k=CountSoFar-1;k>i;k--){
					datastore[k] = datastore[k-1];
				}
				datastore[i] = inp;
				datastore[CountSoFar] = itm;
				CountSoFar++;
				return;
			}
		}
		
		datastore[CountSoFar] = inp;
		CountSoFar++;
		
		
	}
		
	

}

class Input implements Comparable<Input>{
	String txt;
	int len;
	
	public Input(String x){
		this.txt = x;
		this.len = x.length();
	}
	
	@Override
	public int compareTo(Input o) {
		return o.len-this.len;
	}

	@Override
	public String toString() {
		return txt;
	}
	
	
}
