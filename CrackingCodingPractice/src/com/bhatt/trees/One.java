package com.bhatt.trees;

/**
 * 
 * @author bhatt
 *
 */
public class One extends Tree{

	public One(int value) {
		super(value);
	}
	
	public boolean isBalanced(){
		
		if(Math.abs(this.left.maxDepth()-this.right.maxDepth()) >1)
			return false;
		return true;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		One tree = new One(34);
		tree.add(new Tree(45));
		tree.add(new Tree(89));
		tree.add(new Tree(21));
		tree.add(new Tree(76));
		
		System.out.println("is this tree balanced: " + tree.isBalanced());
		
		
		One baltree = new One(5);
		baltree.add(new Tree(8));
		baltree.add(new Tree(3));
		baltree.add(new Tree(4));
		baltree.add(new Tree(2));
		baltree.add(new Tree(7));
		
		System.out.println("is bal tree balanced: " + baltree.isBalanced());
		
		
		
		

	}

}
