package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * Tower of Hanoi
 * @author bhatt
 *
 */
public class Four {
	
	public Stack[] towerofhanoi(Stack[] stacks, int src, int dest){
		
		Node nd = stacks[src].pop();
		if(stacks[src].peek()==null){
			//this was the only one element in the source
			//lets put to destination directly
			stacks[dest].push(nd);
			return stacks;
		}else{
			stacks = towerofhanoi(stacks, 0, 1);
		}
		
		
		
		
		
		return null;
		
		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
