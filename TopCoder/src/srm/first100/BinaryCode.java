package srm.first100;

public class BinaryCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[] decode(String p){
		String[] array = new String[2];
		
		char[] parr = p.toCharArray();
		
		char[] q1 = new char[p.length()];
		char[] q2 = new char[p.length()];
		
		
		/**
		 * assume first one is 0
		 */
		q1[0] = '0';
		
		int secondprev = 0;
		int curr = 0;
		boolean broke = false;
		for(int i=1;i<p.length();i++){
			secondprev = 0;
			if(i>1){
				secondprev = Character.getNumericValue(q1[i-2]);
			}
			curr = Integer.valueOf(parr[i-1]) - Integer.valueOf(q1[i-1]) - secondprev;
			if(curr<0){
				q1= new char[]{'N','O','N','E'};
				broke=true;
				break;
			}
			q1[i] = Character.forDigit(curr, 10);
		}
		/**
		 * validate last char
		 */
		if(!broke)
		if(Character.getNumericValue(parr[parr.length-1])!=(Character.getNumericValue(q1[parr.length-1]) + Character.getNumericValue(q1[parr.length-2]))){
			q1= new char[]{'N','O','N','E'};
		}
		
		
		
		/**
		 * assume first is 1
		 */
		q2[0] = '1';
		broke = false;
		for(int i=1;i<p.length();i++){
			secondprev = 0;
			if(i>1){
				secondprev = Character.getNumericValue(q2[i-2]);
			}
			curr = Integer.valueOf(parr[i-1]) - Integer.valueOf(q2[i-1]) - secondprev;
			if(curr<0){
				q2= new char[]{'N','O','N','E'};
				broke=true;
				break;
			}
			q2[i] = Character.forDigit(curr, 10);
		}
		/**
		 * validate last char
		 */
		if(!broke)
		if(Character.getNumericValue(parr[parr.length-1])!=(Character.getNumericValue(q2[parr.length-1]) + Character.getNumericValue(q2[parr.length-2]))){
			q2= new char[]{'N','O','N','E'};
		}
		
		
		
		
		array[0] = String.valueOf(q1);
		array[1] = String.valueOf(q2);
		
		
		return array;
	}

}
