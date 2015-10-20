package com.bhatt.hr.algo.warm;

/**
 * Given a starting point (0,0) on a Grid, find kth shortest path.
 * Each vertical and horizontal move is described by 'V' or 'H'
 * 
 * for example a path to (2,1) can be achieved in 3 ways
 * HHV
 * HVH
 * VHH
 * 
 * If we sort all these paths lexicographically, return kth element.
 * ie 
 * String findPath(int x, int y, int k);
 * 
 * findPath(1,2,1) = "HHV"
 * findPath(1,2,2) = "HVH"
 * findPath(1,2,3) = "VHH"
 * 
 * @author bhatt
 *
 */
public class FindPath {

	public static String[] gridPath(String[] input){
		String[] allItems = new String[input.length];
		String[] splits;
		int x, y, k;
		StringBuffer sb;
		int i=0;
		for(String str : input){
			splits = str.split(" ");
			sb = new StringBuffer();
			recursivePath(Integer.valueOf(splits[0]), Integer.valueOf(splits[1]), Integer.valueOf(splits[2]), sb);
			allItems[i++] = sb.toString();
		}
		
		return allItems;
	}
	
	public static void recursivePath(int x, int y, int k, StringBuffer sb){
		
		if(k<=0 || (x==0 && y==0)){
			return;
		}
		//number of possible combinations if H is chosen
		int countH = x>0?poss(x-1,y):0;
		
		if(countH>=k){
			sb.append("H");
			recursivePath(--x, y, k, sb);
		}else{
			sb.append("V");
			recursivePath(x, --y, k-countH, sb);
		}
		
	}
	
	/**
	 * computes (x+y)!/(x!*y!)
	 * @param x
	 * @param y
	 * @return
	 */
	public static int poss(int x, int y){
		return fact(x+y)/(fact(x)*fact(y));
	}
	
	/**
	 * compute factorial
	 * @param x
	 * @return
	 */
	public static int fact(int x){
		int fact = 1;
		for(int i=x;i>1;i--){
			fact*=i;
		}
		
		return fact;
	}
	
	
	
	public static void main(String[] args) {
		
		testTwoByTwo();
		System.out.println("***********");
		testTwoByOne();
		
	}

	private static void testTwoByTwo() {
		String inp1 = "2 2 1";
		String inp2 = "2 2 2";
		String inp3 = "2 2 3";
		String inp4 = "2 2 4";
		String inp5 = "2 2 5";
		String inp6 = "2 2 6";
		
		String[] output = gridPath(new String[]{inp1 , inp2, inp3, inp4, inp5, inp6});
		for(String st : output){
			System.out.println(st);
		}
	}
	
	private static void testTwoByOne() {
		String inp1 = "2 1 1";
		String inp2 = "2 1 2";
		String inp3 = "2 1 3";
		
		
		String[] output = gridPath(new String[]{inp1 , inp2, inp3});
		for(String st : output){
			System.out.println(st);
		}
	}
	
	

}
