package com.bhatt.roman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * @author ubuntu
 * 
 */
public class Roman {

	public static void main(String args[]) {
		try{
		StringBuffer sb;
		RomanHandler handler = new OneHandler();
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    int num;
	    while ((line = in.readLine()) != null) {
	    	
	        num = Integer.parseInt(line);
	        sb = new StringBuffer();
	        handler.handle(sb, num);
	        System.out.println(sb);
	    }
		}catch(Exception ex){
			System.out.println("ERROR : " + ex.getMessage());
		}
	
	}

}

enum RomanLiteral {
	ONE(1, "I"), FIVE(5, "V"), TEN(10, "X"), FIFTY(50, "L"), HUNDRED(100, "C"), FIVEHUNDRED(
			500, "D"), THOUSAND(1000, "M");
	int num;
	String literal;

	RomanLiteral(int num, String literal) {
		this.num = num;
		this.literal = literal;
	}

	public static RomanLiteral prevTenthPlace(RomanLiteral num) {
		RomanLiteral prev = null;
		RomanLiteral curr=null;
		RomanLiteral prePrev = null;
		RomanLiteral result = null;
		for (RomanLiteral lit : values()) {
			curr = lit;
			if (lit == num) {
				if (prev != null) {
					if (startWithFive(prev.num)) {
						result = prePrev;
					} else {
						result = prev;
					}
				}
				break;
			}
			prePrev = prev;
			prev = lit;
		}
		return result;
	}

	public static boolean startWithFive(int num) {
		return (String.valueOf(num).startsWith("5"));

	}

}

interface RomanHandler {
	public void handle(StringBuffer sb, int num);
}

class OneHandler implements RomanHandler {

	@Override
	public void handle(StringBuffer sb, int num) {
		RomanLiteral prev = null;
		RomanLiteral next = null;
		for (RomanLiteral roman : RomanLiteral.values()) {
			if (roman.num > num) {
				next = roman;
				break;
			}
			prev = roman;

		}

		// 1. check if this can be taken care by the bigger guy
		if (next != null && RomanLiteral.prevTenthPlace(next) != null
				&& next.num - num <= RomanLiteral.prevTenthPlace(next).num) {
			sb.append(RomanLiteral.prevTenthPlace(next).literal + next.literal);
			num = num - (next.num - RomanLiteral.prevTenthPlace(next).num);
			handle(sb, num);
		} else {
			// 2. can this be taken care by prev smaller guy - substract and see
			// how many left
			if (prev != null) {
				sb.append(prev.literal);
				num = num - prev.num;
				handle(sb, num);
			}
		}

	}

}
