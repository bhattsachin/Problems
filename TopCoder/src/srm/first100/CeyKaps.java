package srm.first100;

/**
 * SRM - 10
 * @author root
 *
 */
public class CeyKaps {
	
	char[] keyboard = new char[26];
	char[] reverseBoard = new char[26];
	char base = 65;
	
	public CeyKaps(){
		init();
	}
	
	public void init(){
		for(char i=base;i<91;i++){
			//System.out.println(i);
			keyboard[i-base] = i;
		}
		
	}
	
	public void reverseBoard(){
		for(char i=base;i<91;i++){
			reverseBoard[keyboard[i-base]-base] = i;
		}
	}

	public static void main(String[] args) {
		CeyKaps cy = new CeyKaps();
		String[] rules = new String[]{"A:B","B:C","A:D"};
		//cy.transform(rules);
		String[] rules2 = new String[]{"A:B","B:C","C:D","D:E","E:A"};
		String[] rules3 = new String[]{"W:O","W:I"};
		
		System.out.println(cy.decipher("AAAAA", rules));
		System.out.println(cy.decipher("ABCDE", rules2));
		System.out.println(cy.decipher("IHWSIOTCHEDMYKEYCAPSARWUND", rules3));
		

	}
	
	
	public void transform(String[] rules){
		String[] arr;
		char tmp;
		for(String rule : rules){
			arr = rule.split(":");
			tmp = this.keyboard[arr[0].charAt(0)-base];
			this.keyboard[arr[0].charAt(0)-base] = this.keyboard[arr[1].charAt(0)-base];
			this.keyboard[arr[1].charAt(0)-base] = tmp;
		}
		reverseBoard();
	}
	
	public String transformedResult(String input){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<input.length();i++){
			sb.append(this.reverseBoard[input.charAt(i)-base]);
		}
		
		return sb.toString();
	}
	
	
	public String decipher(String typed, String[] switches){
		//reset everytime this is called
		init();
		this.transform(switches);
		return this.transformedResult(typed);
		
	}
	

}
