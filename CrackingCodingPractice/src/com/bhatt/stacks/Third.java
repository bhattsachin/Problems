package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * stack of limited size stacks.
 * @author bhatt
 *
 */
public class Third {
	StackContainer head;
	int limit = 4;

	public void push(int val) {

		if (head == null || head.count >= limit) {
			StackContainer nhead = new StackContainer();
			nhead.previous = head; // which is null
			head = nhead;
		}
		Node nd = new Node(val);
		
		head.push(nd);

	}

	public int pop(int container) {
		int containerIdx=0;
		StackContainer item;
		item = head;
		while(item.previous!=null){
			if(containerIdx==container){
				break;
			}
			item = head.previous;
			containerIdx++;
		}
		
		Node nd = item.pop();
		if(item.count<=0){
			head = item.previous;
		}

		return nd.data;
	}
	
	/**
	 * 
	 * @return
	 */
	public int pop(){
		return pop(0);
	}

	/**
	 * 
	 * @param container
	 * @return
	 */
	public int peek(int container) {
		int containerIdx=0;
		StackContainer item;
		item = head;
		while(item!=null){
			if(containerIdx==container){
				break;
			}
			item = item.previous;
			containerIdx++;
		}
		if(item==null || container>containerIdx) return -1;
		Node nd = item.peek();
		return nd.data;
	}

	class StackContainer {

		StackContainer previous;
		Node top;
		int count;

		/**
		 * 
		 * @param node
		 */
		public void push(Node node) {
			if (top == null) {
				top = node;
			} else {
				node.next = top;
				top = node;
			}

			count++;
		}

		/**
		 * 
		 * @return
		 */
		public Node pop() {
			Node ltop = null;
			if (top != null) {
				ltop = top;
				top = top.next;
				count--;
			}

			return ltop;

		}

		/**
		 * 
		 * @return
		 */
		public Node peek() {
			return top;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Third third = new Third();
		third.push(20);
		third.push(40);
		third.push(41);
		third.push(42);
		third.push(43);
		
		System.out.println(third.peek(1));
		
		third.pop(0);
		third.push(89);
		System.out.println(third.peek(0));
		
		
	}

}
