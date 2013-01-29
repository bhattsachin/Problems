package com.bhatt.linked;

/**
 * last n elements
 * @author bhatt
 *
 */
public class Second {
	
	
	public static Node[] findNToEnd(int n, Node head){
		
		Node start = head;
		Node end = null;
		
		int count = 0;
		
		Node curr = head;
		while(curr.next!=null){
			count++;
			if(count>n){
				start = start.next;
			}
			
			end = curr;
			curr = curr.next;
		}
		
		if(count>n){
			Node[] nodes = {start.next, end.next};
			return nodes;
		}else{
			return null;
		}
		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node = new Node(34);
		node.append(2);
		node.append(4);
		node.append(5);
		node.append(6);
		node.append(7);
		node.append(8);
		node.append(9);
		node.append(78);
		
		Node[] result = findNToEnd(5, node.head());
		for(Node nd: result){
			System.out.println(nd.data);
		}

	}

}
