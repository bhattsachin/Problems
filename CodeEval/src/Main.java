

import java.util.ArrayList;
import java.util.List;

/**
 * Traverse through all sequences and if they endup in final state count it towards solution
 * @author bhatt
 *
 */
public class Main {
	
	int len;
	int width;
	
	static int totalpath;
	
	public Main(int len, int width){
		this.len = len;
		this.width = width;
	}
	
	public void traverse(Pass pass){
		int current = pass.visited.get(pass.visited.size()-1); //last dude
		List<Integer> surrounding = getNeighbours(current);
		List<Integer> dummy;
		//items not already traversed
		for(Integer item : pass.visited){
			surrounding.remove(item);
		}
		//stop if nothing left or we are done
		
		if(current==((this.len*(this.width))-1)){
			//System.out.println("this is the end my friend");
			totalpath++;
			return;
		}
		
		for(Integer item : surrounding){
			dummy = new ArrayList<Integer>(pass.visited);
			dummy.add(item);
			traverse(new Pass(dummy));
		}
		
		
		
		
	}
	
	/**
	 * This entity has to be tested on it's own
	 * @param current
	 * @return
	 */
	public List<Integer> getNeighbours(Integer current){
		List<Integer> nighhbours = new ArrayList<Integer>();
		int row = (current+1)/this.len;
		int width = (current+1)%this.len;
		if(width==0){
			row = row-1; //hack added to fix last column issue
			width = this.width - width;
		}
		//System.out.println("row:" + row + " width:" + width);
		//anyone can have max 4 neighbours
		if(row>0){
			nighhbours.add(current - len);
		}
		if(row<len-1){
			//there is one more row
			nighhbours.add(current+len);
		}
		
		if(width>1){
			nighhbours.add(current-1);
		}
		
		if(width<this.width){
			nighhbours.add(current+1);
		}
		
		return nighhbours;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RobotDumb rd = new RobotDumb(3, 3);
//		for(int i=0;i<9;i++){
//			System.out.println("i=" + i + " " + rd.getNeighbours(i));
//		}
//		System.out.println("-----------------");
//		RobotDumb rd1 = new RobotDumb(4, 4);
//		for(int i=0;i<16;i++){
//			System.out.println("i=" + i + " " + rd1.getNeighbours(i));
//		}
		
		Main rd2 = new Main(4,4);
		Pass pass = new Pass();
		rd2.traverse(pass);
		System.out.println(totalpath);

	}

}

/**
 * Represents a pass through data
 * @author bhatt
 *
 */
class Pass{
	List<Integer> visited = new ArrayList<Integer>();
	
	Pass(){
		visited.add(0); //where do we start with 
	}
	
	Pass(List<Integer> visit){
		visited = visit;
	}
	
}
