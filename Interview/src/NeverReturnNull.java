import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NeverReturnNull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<String> getSomeListData(int a){
		if(a==0){
			return Collections.emptyList();
		}else{
			return new ArrayList<String>();
		}
		
		
		
	}

}
