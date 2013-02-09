package com.bhatt.trees;


/**
 * Tree with minimum height,
 * given sorted arraylist
 * @author bhatt
 *
 */
public class Three extends Tree{

	
	public Three(int[] src, int start, int end){
		int size;
		int sleft;
		int sright;
		int smiddle;
		if(start>=0 && end>=0){
			size = end-start+1;
			if(size<2){
				this.value = src[start];
			}else if(size==2){
				this.value = src[end];
				this.left = new Three(src, start, start);
			}else{
				
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
