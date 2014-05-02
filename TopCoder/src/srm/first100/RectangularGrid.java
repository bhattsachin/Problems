package srm.first100;

import java.util.ArrayList;
import java.util.List;


public class RectangularGrid {

	public static void main(String[] args) {
		RectangularGrid grid = new RectangularGrid();
		System.out.println(grid.countRectangles(592, 964));
	}
	
	public long countRectangles(int width, int height){
		RectangularGrid grid = new RectangularGrid();
		List<Dimension> items = grid.getAllRects(width, height);
		long total =0;
		Dimension base = new Dimension(width, height);
		for(Dimension item : items){
			total += grid.countPerm(base, item);
		}
		
		return total;
	}
	
	
	public List<Dimension> getAllRects(int w, int l){
		List<Dimension> items = new ArrayList<Dimension>();
		
		int longerseed =l;	
		int shorterseed = w;
		if(w>l){
			longerseed = w;
			shorterseed = l;
		}
		
		for(int i=longerseed;i>1;i--){
			
			for(int k=(shorterseed<=i)?shorterseed:i;k>=1;k--){
				if(i==k){
					continue;
				}
				items.add(new Dimension(i,k));
			}
			
		}
		
		return items;
	}
	
	public long countPerm(Dimension base, Dimension curr){
		long countSideOne=0;
		/**
		 * side 1
		 */
		if(base.x>=curr.x && base.y>=curr.y){
			countSideOne = (base.x-curr.x+1)*(base.y-curr.y+1);
		}
		
		long countSideTwo=0;
		/**
		 * side 2
		 */
		if(base.y>=curr.x && base.x>=curr.y){
			countSideTwo = (base.y-curr.x+1)*(base.x-curr.y+1);
		}
		
		return countSideOne+countSideTwo;
	}
	
	
	
	

}

class Dimension{
	int x;
	int y;
	
	public Dimension(int xi, int yi){
		this.x = xi;
		this.y = yi;
	}

	@Override
	public String toString() {
		return "Dimension [x=" + x + ", y=" + y + "]";
	}
	
	
}
