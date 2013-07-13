package com.bhatt.routing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Driver {

	List<Point> cities = new ArrayList<Point>();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		List<String> inputText = new ArrayList<String>();
		List<String> indexes = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String coordinates;
		StringTokenizer tokens;
		while ((line = in.readLine()) != null) {
			if (line.indexOf('(') != -1) {
				tokens = new StringTokenizer(line, "|");
				String[] lineArray = line.split("/s");
				coordinates = line.substring(line.indexOf('(') + 1,
						line.indexOf(')'));
				if (lineArray.length > 0) {
					//System.out.println(coordinates);
					indexes.add(tokens.nextToken());
					inputText.add(coordinates);
				}
			}
		}
		in.close();
		
		List<Point> cities = new ArrayList<Point>();
		
		for(int i=0;i<inputText.size();i++){
			cities.add(Point.valueOf(indexes.get(i),inputText.get(i)));
		}
		
		
		findShortestPath(createMatrix(cities), cities);
		
	}
	
	private static double[][] createMatrix(final List<Point> cities){
		double[][] matrix = new double[cities.size()][cities.size()];
		Point pt, pt2;
		for(int i=0;i<cities.size();i++){
			pt = cities.get(i);
			
			for(int j=0;j<cities.size();j++){
				pt2 = cities.get(j);
				matrix[i][j] = DistanceUtil.distFrom(pt, pt2);
			}
		}
		
		return matrix;
		
	}
	
	private static void printListIndex(List<Point> path){
		for(Point pt : path){
			System.out.println(pt.idx);
		}
	}
	
	private static void findShortestPath(double[][] matrix, List<Point> cities){
		List<Point> unvisited = new ArrayList<Point>();
		
		for(Point city : cities){
			unvisited.add(Point.valueOf(city));
		}
		
		
		
		List<Point> path = new ArrayList<Point>();
		double min = 9999;
		int idx = -1;
		//first item
		for(int i=0;i<matrix[0].length;i++){
			if(min>matrix[0][i]){
				min = matrix[0][i];
				idx = i;
			}
		}
		
		unvisited.remove(cities.get(idx));
		path.add(cities.get(idx));
		
		List<Point> result = recursiveShortest(cities, idx, matrix, unvisited, path);
		
		printListIndex(result);
		
	}
	
	private static List<Point> recursiveShortest(List<Point> cities, int current, double[][] matrix, List<Point> unvisited, List<Point> path){
		if(unvisited.isEmpty()) return path;
		double min = 9999;
		int idx = -1;
		for(int i=0;i<matrix[current].length;i++){
			if(min>matrix[current][i] && unvisited.contains(cities.get(i))){
				min = matrix[current][i];
				idx = i;
			}
		}
		
		unvisited.remove(cities.get(idx));
		path.add(cities.get(idx));
		
		return recursiveShortest(cities, idx, matrix, unvisited, path);
		
		
	}
	
	
	
	private static void sortMap(Map<Point, Double> map){
		ValueComparator vc =  new ValueComparator(map);
        TreeMap<Point,Double> sortedMap = new TreeMap<Point,Double>(vc);
        sortedMap.putAll(map);
        System.out.println(sortedMap);
	}
	
	private static void totalDistance(List<Point> cities, int[] idxs){
		double sum = 0;
		for(int i=1;i<idxs.length;i++){
			sum+=DistanceUtil.distFrom(cities.get(idxs[i-1]),cities.get(idxs[i]));
		}
		System.out.println("total=" + sum);
	}

}


