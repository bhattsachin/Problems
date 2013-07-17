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
				smiddle = (int) Math.floor(size/2.0) + start;
				this.value = src[smiddle];
				sleft = smiddle-start+1;
				if(sleft>0){
					this.left = new Three(src, start, smiddle-1);
				}
				sright = end-smiddle+1;
				if(sright>0){
					this.right = new Three(src, smiddle+1, end);
				}
			}
			
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] src = {1,2,3,4,5,6,7,8,9,10};
		Three three = new Three(src,0,9);
		
		three.traverseBreadthFirst();
		
		
		

	}

}
