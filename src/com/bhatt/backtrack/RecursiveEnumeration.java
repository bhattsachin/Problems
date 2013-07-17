package com.bhatt.backtrack;

/**
 * Given a level number n and set of possible states at each node. 
 * output all the possible enumerations
 * @author bhatt
 *
 */
public class RecursiveEnumeration {
	
	static int[][] table;
	static int counter;

	/**
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tNode = 4;
		int tState = 2;
		int tEdges = 3;
		
		
		int row = (int)Math.pow(tNode, tState);
		int col = 2*(tNode);
		
		RecursiveEnumeration re = new RecursiveEnumeration();
		
		table = new int[row][col];
		
		re.enumerate(0,3,null,1);
		System.out.println("Table: " + table);
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(" " + table[i][j]);
			}
			System.out.println(""); //empty row
		}

	}
	
	/**
	 * enumerate all the values recursively
	 * @param cNode
	 * @param tNode
	 * @param vArray
	 */
	public void enumerate(int cNode, int tNode, int[] vArray, int tState){
		
		for(int k=0;k<=tState;k++){
			if(cNode==0){
				vArray = new int[tNode + 1];
			}
			vArray[cNode] = k;
			if(cNode < tNode){
				enumerate(cNode+1, tNode, vArray, tState);
			}else{
				for(int j=0;j<=tNode;j++){
					table[counter][j] = vArray[j];
				}
				counter++;
			}
			
			
		}
		
		
		
		
	}

}
