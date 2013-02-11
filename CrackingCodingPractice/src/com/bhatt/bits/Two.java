package com.bhatt.bits;

/**
 * Decimal to Binary
 * @author bhatt
 *
 */
public class Two {
	
	public int getIntPart(String num){
		int idx = num.indexOf(".");
		int inum;
		num = num.substring(0, idx);
		inum = Integer.parseInt(num);
		
		return inum;
	}
	
	public double getDecPart(String num){
		int idx = num.indexOf(".");
		double dnum;
		num = num.substring(idx, num.length());
		dnum = Double.parseDouble(num);
		
		return dnum;
		
	}
	
	public String decToBinary(int inum, double dnum){
		StringBuffer sb = new StringBuffer();
		double drem;
		int rem;
		while(inum>0){
			rem = inum%2;
			sb.append(rem);
			inum = inum/2;
		}
		sb.append(".");
		//decimal part
		while(true){
			if(sb.length()>64)
				return "ERROR";
			if(dnum==1.0){
				sb.append("1");
				break;
			}
			
			drem = dnum*2;
			if(drem>1){
				dnum = drem-1;
				sb.append("1");
			}else{
				dnum = drem;
				sb.append("0");
			}
		
		}
		
		
		return sb.toString();
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String num = "3.72";
		Two two = new Two();
		
		System.out.println("int val: " + two.getIntPart(num));
		System.out.println("dec part: " + two.getDecPart(num));
		System.out.println(two.decToBinary(two.getIntPart(num), two.getDecPart(num)));
		
		

	}

}
