package srm.first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TennisRallies {
	List<Character[]> items = new ArrayList<Character[]>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 18;
		Character[] base = new Character[limit];
		TennisRallies tr = new TennisRallies();
		tr.findAllPossible(base, 0, limit);
		System.out.println(tr.items.size());
		for(Character[] itm : tr.items){
			System.out.println(Arrays.toString(itm));
		}

	}
	
	
	private void findAllPossible(Character[] base, int curr, int limit){
		if(curr>=limit){
			items.add(base.clone());
			return;
		}
		for(char p : new char[]{'c', 'd'}){
			base[curr] = p;
			
			findAllPossible(base, curr+1, limit);
			
			
		}
	}

}
