package com.bhatt.linked;

public class LinKedList {
	Node next;
	int data;

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(5);
		head.append(8);
		head.append(11);
		head.append(4);
		head.append(89);
		head.append(4);
		//head.append(6);
		head.print();
		
		
		head.delete(4);
		
		head.print();
		
	}

}

