import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Main main = new Main();
    String s;
    while ((s = in.readLine()) != null) {
      System.out.println(s);
      int a = Integer.parseInt(s);
      System.out.println(main.isHappy(a, 0));
    }
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
	