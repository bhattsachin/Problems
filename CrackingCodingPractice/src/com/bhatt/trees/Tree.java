package com.bhatt.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary tree implementation
 * 
 * @author bhatt
 * 
 */
public class Tree {

	int value;
	Tree left;
	Tree right;

	public Tree(int value) {
		this.value = value;
	}
	
	public Tree(){
		
	}

	public void add(Tree tree) {
		if (tree.value > this.value) {
			if (this.right == null)
				this.right = tree;
			else
				this.right.add(tree);
		} else {

			if (this.left == null)
				this.left = tree;
			else
				this.left.add(tree);

		}
	}

	/**
	 * traverse breadth first
	 * 
	 * @param queue
	 */
	public void traverseBreadthFirst() {
		Tree tmp;
		Queue queue = new LinkedList<Tree>();
		queue.offer(this);
		while (queue.peek() != null) {
			tmp = (Tree) queue.poll();
			System.out.println(tmp.value + ", ");

			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}

	}

	/**
	 * traverse depth first
	 */
	public void traverseDepthFirst() {
		Stack stack = new Stack();
		stack.push(this);
		Tree tmp;
		while (stack.peek() != null) {
			tmp = (Tree) stack.pop();
			System.out.println(tmp.value);
			if (tmp.left != null)
				stack.push(tmp.left);
			if (tmp.right != null)
				stack.push(tmp.right);
		}
	}

	/**
	 * 
	 * @return
	 */
	public int maxDepth() {
		if (this.left == null && this.right == null)
			return 0; // this dude is leaf node
		if (this.left == null || this.right == null) {
			if (this.left != null)
				return this.left.maxDepth() + 1;
			else
				return this.right.maxDepth() + 1;
		}
		return (Math.max(this.left.maxDepth(), this.right.maxDepth()) + 1);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Tree tree = new Tree(34);
		tree.add(new Tree(45));
		tree.add(new Tree(89));
		tree.add(new Tree(21));
		tree.add(new Tree(76));

		tree.traverseBreadthFirst();

		System.out.println("=====depth first=====");

		tree.traverseDepthFirst();

	}

}
