package com.bhatt.math;

import org.apache.mahout.math.Matrix;
import org.apache.mahout.math.SparseMatrix;

public class MatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Matrix mat = new SparseMatrix(3,4);
		for(int i=0;i<3;i++){
			for(int k=0;k<4;k++){
				mat.setQuick(i, k, Math.random()*10);
			}
		}
		
		System.out.println("matrix is:" + mat.viewRow(2));
		

	}

}
