package com.bhatt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * sum closest to zero
 * @author sachinch@buffalo.edu
 *
 */

/**
 * This problem has been generalized and presented in different forms.It can be broken into 3 parts
 * 1. minimum sum can be obtained by adding smallest numbers on positive scale (-34,3,4,56) ie 3,4 as answer
 * 2. or first 2 smallest of negative numbers i.e. (-1,-4) in (-8,-4,-1,23,34)
 * 3. or the negative numbers which are equi-distant from their positive counterparts on number scale. ie (-23,-4,8,21) we have (-23,21) summing to lowest
 * 
 * So we compute above 3 and select one which gives minimum sum of these
 * 
 * Further it can be generalized for 2,3,4 numbers. for odd numbers case, one number will always be from case (1,2) and the remaining two may come from 
 * 3 but not necessarily
 */
public class SumCloseToZero {
	public static int[] TEST_ARRAY = {3,1,-4,78,-9,8,6,5,-34,16};
	public static int[] TEST_ARRAY_ONE = {-34,3,4,56};
	public static int[] TEST_ARRAY_TWO = {-8,-4,-1,23,34};
	public static int[] TEST_ARRAY_THREE = {-45,-23,-4,8,21};
	public int[] closestToZero(int[] input){
		//all positive integers here
		List<Integer> positive = new ArrayList<Integer>(); 
		//similarly
		List<Integer> negative = new ArrayList<Integer>();
		//split positive and negative numbers into two arrays
		for(int i=0;i<input.length;i++){
			if(input[i]>0){
				positive.add(input[i]);
			}else{
				negative.add(input[i]);
			}
		}

		//sort em (O(nlog n))
		Collections.sort(positive);
		Collections.sort(negative);
		
		int oneSum,twoSum,threeSum;
		oneSum=twoSum=threeSum= 99999; //assuming this is the largest sum we can obtain on the input 
		int[] oneAns,twoAns,threeAns;
		oneAns = new int[2];
		twoAns = new int[2];
		threeAns = new int[2];
		if(positive.size()>1){
			oneAns[0] = positive.get(0);
			oneAns[1] = positive.get(1);
			oneSum = oneAns[0] + oneAns[1];
		}
		
		if(negative.size()>1){ //since order ascending, last two will be closest to zero
			twoAns[0] = negative.get(negative.size()-1);
			twoAns[1] = negative.get(negative.size()-2);
			twoSum = Math.abs(twoAns[0] + twoAns[1]);
		}
		
		//worst case this can run for O((n/2)*(n/2))
		if(negative.size()>0){
			for(int k=0;k<negative.size();k++){
				for(int i=0;i<positive.size();i++){
					if(Math.abs(Math.abs(negative.get(k))-positive.get(i))<threeSum){
						threeSum = Math.abs(Math.abs(negative.get(k))-positive.get(i));
						threeAns[0] = negative.get(k);
						threeAns[1] = positive.get(i);
					}
				}
			}
		}
		
		if(oneSum<twoSum && oneSum<threeSum){
		    return oneAns;
		}else if(twoSum<threeSum && twoSum<oneSum){
		    return twoAns;
		}else{
		   return threeAns;
		}
	}
	
	
	public static void main(String args[]){
		SumCloseToZero instance = new SumCloseToZero();
		int[] smallest = instance.closestToZero(TEST_ARRAY);
		System.out.println("closest to zero random:" + smallest[0] + ", " + smallest[1]);
		smallest = instance.closestToZero(TEST_ARRAY_ONE);
		System.out.println("closest to zero case One:" + smallest[0] + ", " + smallest[1]);
		smallest = instance.closestToZero(TEST_ARRAY_TWO);
		System.out.println("closest to zero case two:" + smallest[0] + ", " + smallest[1]);
		smallest = instance.closestToZero(TEST_ARRAY_THREE);
		System.out.println("closest to zero case three:" + smallest[0] + ", " + smallest[1]);
	}
}
