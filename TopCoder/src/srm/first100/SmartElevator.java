package srm.first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SRM 25
 * @author root
 *
 */
public class SmartElevator {

	public static void main(String[] args) {
		
		SmartElevator se = new SmartElevator();
		System.out.println("first set:" + se.findEndTime(5, 30, 50, 1));
		System.out.println("first set:" + se.findEndTime(100, 30, 50, 1));
		
		
		se.init(1);
		
		for(Integer[] itm : se.possibilities){
			System.out.println(Arrays.toString(itm));
		}
		

	}
	
	List<Integer[]> possibilities = new ArrayList<Integer[]>();
	
	
	public int calculateTime(Integer[] sequence, int[] arrival, int[] startFloor, int[] destFloor){
		int elevatorStart = 1;
		int currTime=0;
		for(Integer seq : sequence){
			currTime = this.findEndTime(arrival[seq], startFloor[seq], destFloor[seq], elevatorStart);
			elevatorStart = destFloor[seq];
			
		}
		
		return 0;
	}
	
	
	public int findEndTime(int arrivalTime, int startFloor, int endFloor, int elevatorInitialPosition){
		/**
		 * How much will it take for elevator to reach to where this dude is waiting
		 */
		 int elevatorDistance = Math.abs(startFloor-elevatorInitialPosition);
		 int startTime=0;
		 /**
		  * If our dude arrives late then all we care is his arrival time,
		  * else our dude will wait for elevator until he gets spider man powers
		  */
		 if(arrivalTime>elevatorDistance){
			 startTime = arrivalTime;
		 }else{
			 startTime = elevatorDistance;
		 }
		 
		 int destinationTime = startTime + Math.abs(endFloor-startFloor);
		
		
		return destinationTime;
	}
	
	public void findAllPermuatations(Integer[] base, int curr, Set<Integer> remaining){
		/**
		 * exit criteria
		 */
		if(remaining.isEmpty()){
			this.possibilities.add(base.clone());
			return;
		}
		
		Set<Integer> tmpRemain;
		
		for(Integer itm : remaining){
			tmpRemain = new HashSet<Integer>(remaining);
			base[curr] = itm;
			tmpRemain.remove(itm);
			findAllPermuatations(base, curr+1, tmpRemain);
		}
		
	}
	
	public void init(int total){
		Integer[] base = new Integer[total];
		Set<Integer> remain = new HashSet<Integer>();
		for(int i=0;i<total;i++){
			remain.add(i);
		}
		this.findAllPermuatations(base, 0, remain);
	}

}
