package com.bhatt.linked;

/**
 * Circular linked list
 * @author bhatt
 *
 */
public class Five {
	
	public static void findLoop(Node head){
		Node slow = head;
		Node fast = head;
		
		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow.data==fast.data){
				break;
			}
		}
		
		System.out.println(slow.data);
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.append(2);
		Node third = new Node(3);
		node.append(24);
		node.append(third);
		node.append(4);
		node.append(5);
		node.append(third);
		
		findLoop(node);
		
		
	}

}
