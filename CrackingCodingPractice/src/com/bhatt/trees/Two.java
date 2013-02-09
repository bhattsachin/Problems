package com.bhatt.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iteratively go through all the nodes in the graph and check whether they
 * match with the target node
 * 
 * @author bhatt
 * 
 */
public class Two extends Tree {

	boolean visited = false;

	public Two(int value) {
		super(value);
	}

	public boolean isThereARoute(int target) {

		if (this.value == target)
			return true; // this was the node itself

		Queue queue = new LinkedList();
		queue.offer(this);
		Two tleft;
		Two tright;
		Two tmp;
		while (queue.peek() != null) {
			tmp = (Two) queue.poll();
			tmp.visited = true;

			if (tmp.left != null) {
				tleft = (Two) tmp.left;
				if (!tleft.visited)
					queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				tright = (Two) tmp.right;
				if (!tright.visited)
					queue.offer(tmp.right);
			}

			if (tmp.value == target)
				return true;

		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Two two = new Two(34);
		two.add(new Two(90));
		two.add(new Two(67));
		two.add(new Two(12));
		two.add(new Two(23));
		two.add(new Two(22));
		two.add(new Two(1));
		two.add(new Two(78));
		
		System.out.println("does this tree contain 22 :" + two.isThereARoute(22) );
		
		System.out.println("does this tree contain 22 :" + two.isThereARoute(11) );
		
		
		
		

	}

}
