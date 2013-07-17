package com.bhatt.linked;

/**
 * 
 * @author bhatt
 *
 */
public class First {
	static Node nodes = new Node(23);
	
	public static void removeDuplicateWithNode(Node head){
		Node curr = head;
		Node lcurr = null;
		Node prev = curr;
		while(curr.next!=null){
			curr = curr.next;
			//checkAnyoneFromHeadToPrev
			if(ifExistsBefore(head, prev, prev.next)){
				//donotaddnewguy
				curr = curr.next;
				prev.next = curr;
			}
			prev = curr;
		}
		
	}
	
	/**
	 * if exists already
	 * @param head
	 * @param last
	 * @param test
	 * @return
	 */
	private static boolean ifExistsBefore(Node head, Node last, Node test){
		Node curr = head;
		boolean match = false;
		while(curr.next!=null && curr.data!=last.data){
			if(curr.data == test.data){
				match = true;
			}
			curr = curr.next;
		}
		return match;
	}
	
	
	
	
	public static void main(String args[]){
		
		nodes.append(45);
		nodes.append(56);
		nodes.append(9);
		nodes.append(123);
		nodes.append(56);
		nodes.append(345);
		nodes.append(9);
		nodes.append(8);
		
		nodes.print();
		
		removeDuplicateWithNode(nodes);
		
		System.out.println("---------");
		
		nodes.print();
	}

}
