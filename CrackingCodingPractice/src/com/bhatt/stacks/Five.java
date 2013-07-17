package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * Queue using two stacks
 * 
 * @author bhatt
 * 
 */
public class Five {

	Stack first = new Stack();
	Stack second = new Stack();
	boolean ispush = true;

	/**
	 * 
	 * @param d
	 */
	public void enqueue(int d) {
		Node nd = new Node(d);
		Node tmp;
		if (ispush) {
			first.push(nd);
		} else {
			while (second.peek() != null) {
				tmp = second.pop();
				first.push(tmp);
			}
			// nowaddthedude
			first.push(nd);
		}
		
		ispush = true;

	}

	/**
	 * 
	 * @return
	 */
	public int dequeue() {
		Node tmp;
		if(!ispush){
			return second.pop().data;
		}else{
			while(first.peek()!=null){
				tmp = first.pop();
				
				second.push(tmp);
				
			}
			
			ispush = false;
			return second.pop().data;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Five five = new Five();
		five.enqueue(5);
		five.enqueue(7);
		five.enqueue(0);
		System.out.println(five.dequeue());
		five.enqueue(89);
		five.enqueue(23);
		System.out.println(five.dequeue());
		System.out.println(five.dequeue());
		System.out.println(five.dequeue());
		System.out.println(five.dequeue());
		
		
	}

}
