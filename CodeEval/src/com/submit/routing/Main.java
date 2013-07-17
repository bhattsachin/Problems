package com.submit.routing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;




public class Main {


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		
		if(args.length!=1) {
			System.out.println("insufficient args");
			return;
		}
		try{
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
				coordinates = line.substring(line.indexOf('(') + 1,
						line.indexOf(')'));
					indexes.add(tokens.nextToken());
					inputText.add(coordinates);
			}
		}
		in.close();
		
		List<Point> cities = new ArrayList<Point>();
		
		for(int i=0;i<inputText.size();i++){
			cities.add(Point.valueOf(indexes.get(i),inputText.get(i)));
		}
		
		
		findShortestPath(createMatrix(cities), cities);
		}catch (IOException ex){
			System.out.println("Error reading file" + ex.getMessage());
		}
		
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
	


}

class DistanceUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double distFrom(Point pt1, Point pt2) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(pt2.lat-pt1.lat);
		double dLng = Math.toRadians(pt2.lng-pt1.lng);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
		            * Math.cos(Math.toRadians(pt1.lat)) * Math.cos(Math.toRadians(pt2.lat));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dist = earthRadius * c;

		return dist;
	}
	
	
	public static List<Point> parsePoints(final String text){
		return null;
	}
	
	

}

class Point {
	
	double lat;
	double lng;
	
	long idx;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		return true;
	}

	public static Point valueOf(String idx, String txt){
		if(txt!=null){
			
			String[] latlng = txt.split(",");
			if(latlng.length!=2) return null; //incorrect input
			
			Point pt = new Point();
			pt.idx = Long.parseLong(idx.trim());
			pt.lat = (double)Double.parseDouble(latlng[0].trim());
			pt.lng = (double)Double.parseDouble(latlng[1].trim());
			
			return pt;
			
		}
		
		return null;
	}
	
	public static Point valueOf(Point pt){
		Point newPoint = new Point();
		newPoint.idx = pt.idx;
		newPoint.lat = pt.lat;
		newPoint.lng = pt.lng;
		
		return newPoint;
	}

	@Override
	public String toString() {
		return "Point [idx=" + idx + "]";
	}

	
	

}




