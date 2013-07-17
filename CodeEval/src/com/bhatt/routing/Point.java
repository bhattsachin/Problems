package com.bhatt.routing;

import java.util.Comparator;
import java.util.Map;

public class Point {
	
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

class ValueComparator implements Comparator<Point> {

    Map<Point, Double> base;
    public ValueComparator(Map<Point, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(Point a, Point b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
