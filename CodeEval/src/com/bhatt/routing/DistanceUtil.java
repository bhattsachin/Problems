package com.bhatt.routing;

import java.util.List;

public final class DistanceUtil {

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
