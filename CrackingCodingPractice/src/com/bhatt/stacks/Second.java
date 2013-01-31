package com.bhatt.stacks;


/**
 * Push, Pop, Min in O(1) time
 * 
 * @author bhatt
 * 
 */
public class Second {

	StackNodeMin top;

	public void push(int val) {
		int min;
		StackNodeMin node = new StackNodeMin(val, val, null);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			min = node.min < top.min ? node.min : top.min;
			top = node;
			top.min = min;
		}

	}

	public int pop() {
		StackNodeMin node = null;
		if (top != null) {
			node = top;
			top = top.next;
		}
		if (node != null)
			return node.value;
		else
			return -1;
	}

	public int min() {
		StackNodeMin node = top;
		
		if (node != null)
			return node.min;
		else
			return -1;
	}
	
	public int peek(){
		StackNodeMin node = top;
		
		if (node != null)
			return node.value;
		else
			return -1;
	}

	

	class StackNodeMin {
		int min;
		int value;
		StackNodeMin next;

		public StackNodeMin(int min, int value, StackNodeMin next) {
			this.min = min;
			this.value = value;
			this.next = next;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Second second = new Second();
		second.push(9);
		second.push(34);
		second.push(2);
		second.push(77);
		
		System.out.println(second.peek());
		System.out.println(second.min());
		
		
		

	}

}
