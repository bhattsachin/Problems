package srm.first100;

/**
 * SRM - 30
 * @author root
 *
 */
public class TireRotation {

	public static void main(String[] args) {
		TireRotation tr = new TireRotation();
		System.out.println(tr.getCycle("ABCD", "ABCD"));
		System.out.println(tr.getCycle("ABCD", "DCAB"));
		System.out.println(tr.getCycle("ABCD", "CDBA"));
		System.out.println(tr.getCycle("ABCD", "ABDC"));
		System.out.println(tr.getCycle("ZAXN", "XNAZ"));
	}
	
	public int getCycle(String inital, String current){
		if(inital.length()!=4 || current.length()!=4){
			return -1;
		}
		char[] inp = inital.toCharArray();
		Car car = new Car(inp[0], inp[1],inp[2], inp[3]);
		
		if(current.equals(car.position1)){
			return 1;
		}else if(current.equals(car.position2)){
			return 2;
		}else if(current.equals(car.position3)){
			return 3;
		}else if(current.equals(car.position4)){
			return 4;
		}
		
		
		return -1;
	}

}

class Car{
	String position1;
	String position2;
	String position3;
	String position4;
	public Car(char tyre1, char tyre2, char tyre3, char tyre4){
		this.position1 = String.valueOf(new char[]{tyre1, tyre2, tyre3, tyre4});
		this.position2 = String.valueOf(new char[]{tyre4, tyre3, tyre1, tyre2});
		this.position3 = String.valueOf(new char[]{tyre4, tyre3, tyre1, tyre2});
		this.position4 = String.valueOf(new char[]{tyre3, tyre4, tyre2, tyre1});
	}
}
