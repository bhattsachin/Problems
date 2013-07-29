package com.bhatt.datacenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author sbhatt
 *
 */
public class DataCenter {
	private int m;
	private int n;
	private int[][] machines;
	
	
	public DataCenter(int[][] machines) {
		this.m = machines.length;
		this.n = machines[0].length;
		this.machines = machines;
	}

	/**
	 * Reads input from a file
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] machines = null;
		int m=-1, n=-1;
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int count=0;
			boolean firstLine = true;
			while ((line = in.readLine()) != null) {
				String[] lineArray = line.split(" ");
				if(firstLine){
					if(lineArray.length!=2){
						throw new Exception("Data Format Error. Invalid m, n values");
					}
					firstLine = false;
					m = Integer.parseInt(lineArray[0]);
					n = Integer.parseInt(lineArray[1]);
					machines = new int[m][n];
					continue;
				}
				if(lineArray.length!=n){
					throw new Exception("Data Format Error");
				}
				if (lineArray.length > 0) {
					for(int i=0;i<lineArray.length;i++){
						machines[count][i] = Integer.parseInt(lineArray[i]);
					}
					count++;
				}

			}
			
			DataCenter dc = new DataCenter(machines);
			dc.compute();
			
		} catch (Exception ex) {
			System.out.println("error: " + ex.getMessage());
		}

	}
	
	/**
	 * Main executing method
	 */
	public void compute(){
		computeDataCenter(this.machines);
	}

	/**
	 * Computes datacenter capacity. Each column of matrix 
	 * is stored in a Map. Max value O(m) from each map is taken into account
	 * to be max value for that dataset.
	 * @param machines
	 */
	public void computeDataCenter(final int[][] machines) {
		List<Map<Integer, Integer>> cols = new ArrayList<Map<Integer, Integer>>();
		sumColumnValues(machines, cols);

		int[] items = new int[n];
		for (int i = 0; i < n; i++) {
			items[i] = getMaxValueCount(cols.get(i));
		}

		// min of items array
		int minVal = getMinValueCount(items);
		System.out.println("" + minVal * 100);

	}

	/**
	 * Extracts all version values from machines array and 
	 * maps it to cols List as Map<Integer, Integer>
	 * @param machines
	 * @param cols
	 */
	private void sumColumnValues(final int[][] machines,
			List<Map<Integer, Integer>> cols) {
		int key;
		int value;
		Map<Integer, Integer> tmpMap;
		// iterate column wise
		for (int j = 0; j < n; j++) {
			tmpMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < m; i++) {
				key = machines[i][j];
				if (tmpMap.containsKey(key)) {
					value = tmpMap.get(key);
					value++;
					tmpMap.put(key, value);
				} else {
					tmpMap.put(key, 1);
				}

			}
			cols.add(tmpMap);
		}
	}

	/**
	 * returns in O(m) time
	 * 
	 * @param items
	 * @return
	 */
	public static int getMaxValueCount(final Map<Integer, Integer> items) {
		int maxVal = -1;
		int val;
		for (Integer key : items.keySet()) {
			val = items.get(key);
			if (val > maxVal) {
				maxVal = val;
			}
		}

		return maxVal;
	}

	/**
	 * takes O(m) to get min of m values at worst case. 
	 * @param inputArray
	 * @return
	 */
	public static int getMinValueCount(final int[] inputArray) {
		if(inputArray.length<1)
			return -1;
		int minVal = inputArray[0]; 
		int val;
		for (int i = 0; i < inputArray.length; i++) {
			val = inputArray[i];
			if (val < minVal) {
				minVal = val;
			}
		}

		return minVal;
	}
	

}
