package telephone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	  public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    String keys;
	    String result;
	    while ((s = in.readLine()) != null) {
	      //System.out.println(s);
	    	keys = generateKeys(s);
	    	result = sortem(keys);
	    	System.out.println(result);
	    }
	  }
	  
	  
	  public static String sortem(String keys){
		  String[] vals = keys.split(",");
		  Arrays.sort(vals);
		  boolean first = true;
		  StringBuffer sb = new StringBuffer();
		  for(String val : vals){
			  if(first){
				  sb.append(val);
				  first = false;
			  }else{
				  sb.append("," + val);
			  }
		  }
		  
		  
		  return sb.toString();
	  }
	  
	  public static String generateKeys(String input) {
			// check if length is 7
			if (input.length() != 7) {
				return "";
			}
			
			//also check if input contains anything other than digits
			
			boolean first = true;
			StringBuffer sb = new StringBuffer();
			// run 7 for loops, ugly but quick
			char[] ca = getPadChars(input.charAt(0));
			for (int a = 0; a < ca.length; a++) {
				char[] cb = getPadChars(input.charAt(1));
				for (int b = 0; b < cb.length; b++) {
					char[] cc = getPadChars(input.charAt(2));
					for (int c = 0; c < cc.length; c++) {
						char[] cd = getPadChars(input.charAt(3));
						for (int d = 0; d < cd.length; d++) {
							char[] ce = getPadChars(input.charAt(4));
							for (int e = 0; e < ce.length; e++) {
								char[] cf = getPadChars(input.charAt(5));
								for (int f = 0; f < cf.length; f++) {
									char[] cg = getPadChars(input.charAt(6));
									for (int g = 0; g < cg.length; g++) {
										if(first){
											sb.append("" + ca[a] + cb[b] + cc[c] + cd[d] + ce[e] + cf[f] + cg[g]);
											first = false;
										}else{
											sb.append("," + ca[a] + cb[b] + cc[c] + cd[d] + ce[e] + cf[f] + cg[g]);
										}
										
									}
								}
							}
						}
					}

				}
			}

			return sb.toString();
		}

		static char[] zero = { '0' };
		static char[] one = { '1' };
		static char[] two = { 'a', 'b', 'c' };
		static char[] three = { 'd', 'e', 'f' };
		static char[] four = { 'g', 'h', 'i' };
		static char[] five = { 'j', 'k', 'l' };
		static char[] six = { 'm', 'n', 'o' };
		static char[] seven = { 'p', 'q', 'r', 's' };
		static char[] eight = { 't', 'u', 'v' };
		static char[] nine = { 'w', 'x', 'y', 'z' };

		public static char[] getPadChars(char digit) {
			char[] empty = { '_' };
			switch (digit) {
			case '0':
				return zero;
			case '1':
				return one;
			case '2':
				return two;
			case '3':
				return three;
			case '4':
				return four;
			case '5':
				return five;
			case '6':
				return six;
			case '7':
				return seven;
			case '8':
				return eight;
			case '9':
				return nine;
			}

			return empty;
		}
	  
	}
