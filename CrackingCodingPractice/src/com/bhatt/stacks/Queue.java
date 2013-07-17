package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * No limit queue, linked list implementation
 * @author bhatt
 *
 */
public class Queue {
	
	Node begin;
	Node end;
	
	public void enqueue(Node data){
		if(begin==null){
			begin = data;
			end = data;
		}else{
			end.next = data;
			end = data;
		}
		
	}
	
	public Node dequeue(){
		Node ldata = null;
		if(begin!=null){
			ldata = begin;
			begin = begin.next;
		}
		return ldata;
	}
	
	public Node peek(){
		return begin;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Queue que = new Queue();
		Node nd = new Node(34);
		Node nd2 = new Node(2);
		Node nd3 = new Node(6);
		Node nd4 = new Node(90);
		Node nd5 = new Node(23);
		
		que.enqueue(nd);
		que.enqueue(nd2);
		que.enqueue(nd3);
		
		System.out.println(que.peek().data);
		que.dequeue();
		System.out.println(que.peek().data);
		

	}

}
