package com.bhatt.arrays;

/**
 * 
 * @author bhatt make entire row or column equals zero if a cell is zero
 */
public class Seven {

	static int INDEX = 5;

	/**
	 * Not an in place implementation
	 * @param inputMatrix
	 * @return
	 */
	public static int[][] makeMatrixZero(int[][] inputMatrix) {
		int[][] outputMat = zeroInit();

		for (int i = 0; i < INDEX; i++) {
			for (int j = 0; j < INDEX; j++) {
				if(outputMat[i][j] !=0)
					outputMat[i][j] = inputMatrix[i][j];
				
				if (inputMatrix[i][j] == 0) {
					for (int k = 0; k < INDEX; k++) {
						outputMat[i][k] = 0;
						outputMat[k][j] = 0;
					}
				} 

			}
		}

		return outputMat;
	}

	public static void main(String args[]) {
		int[][] inputMat = init();
		
		System.out.println("BEFORE:");
		printMat(inputMat);
		
		
		
		int[][] outputMat = makeMatrixZero(inputMat);
		System.out.println("AFTER:");
		printMat(outputMat);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static int[][] init(){
		int[][] inputMat = new int[INDEX][INDEX];
		for (int i = 0; i < INDEX; i++) {
			for (int j = 0; j < INDEX; j++) {
				inputMat[i][j] = (int) Math.floor(8*Math.random()); //add random values
			}
		}
		
		return inputMat;
	}
	
	/**
	 * 
	 * @param inputMat
	 */
	public static void printMat(int[][] inputMat){
		for (int i = 0; i < INDEX; i++) {
			System.out.println();
			for (int j = 0; j < INDEX; j++) {
				System.out.print(inputMat[i][j] + " ");
				
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static int[][] zeroInit(){
		int[][] inputMat = new int[INDEX][INDEX];
		for (int i = 0; i < INDEX; i++) {
			for (int j = 0; j < INDEX; j++) {
				inputMat[i][j] = -1;
			}
		}
		
		return inputMat;
	}
	
	
}
