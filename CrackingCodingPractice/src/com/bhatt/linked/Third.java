package com.bhatt.linked;

/**
 * Delete given node from single linked list
 * @author bhatt
 *
 */

public class Third {
	
	
	public static void deleteJustThatNode(Node head, Node given){
		Node curr = head;
		while(curr.data!=given.data){
			curr = curr.next;
			//this is part of pre-step
		}
		
		Node next = curr.next;
		curr.data = next.data;
		curr.next = next.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Node node = new Node(34);
		node.append(3);
		node.append(4);
		
		Node newboy = new Node(8);
		node.append(newboy);
		node.append(5);
		
		node.print();
		
		deleteJustThatNode(node, newboy);
		node.print();

	}

}
