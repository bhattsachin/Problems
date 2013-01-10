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

class Node {
	
	Node next;
	int data;
	
	public Node(int nData){
		this.data = nData;
	}
	
	public void append(int nData){
		Node node = new Node(nData);
		Node curr = this;
		while(curr.next!=null){
			curr = curr.next;
		}
		curr.next = node;
	}
	
	public void delete(int nData){
		Node curr = this;
		Node prev = null;
		Node nxt = null;
		while(curr.next!=null){
			if(curr.data == nData){
				nxt = curr.next;
				if(prev!=null){
					prev.next = nxt;
					curr = prev;
				}
			}
			prev = curr;
			curr = curr.next;
			
		}
		
		//if last one is the dude delete it too
		if(curr.data == nData){
			nxt = curr.next;
			if(prev!=null){
				prev.next = nxt;
			}
		}
		
		
	}
	
	public void print(){
		System.out.println("------------Begin--------------");
		Node curr = this;
		while(curr.next!=null){
			System.out.println(curr.data );
			curr = curr.next;
		}
		System.out.println(curr.data);
		
	}
	
	public static void main(String args[]){
		
		
		
	}

}
