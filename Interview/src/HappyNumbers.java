
public class HappyNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String num = "23";
//		int a = 45;
//		int sum = 0;
//		int rem = 0;
//		while(a/10>0){
//			rem = a%10;
//			a = a/10;
//			sum = sum + (rem*rem); 
//		}
//		sum = sum + a*a;
		
		HappyNumbers numbers = new HappyNumbers();
		System.out.println(numbers.isHappy(7, 0));
		System.out.println(numbers.isHappy(22, 0));

	}
	
	
	public int isHappy(int a, int depth){
		
		//split the number
		//square each and add
		//if not one call it again
		//if total tries reached a limit return false
		int sum = 0;
		int rem = 0;
		while(a/10>0){
			rem = a%10;
			a = a/10;
			sum = sum + (rem*rem); 
		}
		sum = sum + a*a;
		a = sum;
		if(a==1){
			//System.out.println("depth: " + depth);
			return 1;
		}
		
		
		if(depth<25){ //lets limit stack size to 25 - might not be enough though
			depth = depth+1;
			return isHappy(a, depth);
		}else{
			return 0; //may be we are getting into an big cycle
		}
		
	}
	
	

}
