package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * No limit stack
 * @author bhatt
 *
 */
public class Stack {
	
	Node top;
	
	
	public void push(Node node){
		
		if(top==null){
			top = node;
		}else{
			node.next = top;
			top = node;
		}
		
		
	}
	
	public Node pop(){
		Node ltop = null;
		if(top!=null){
			ltop = top;
			top = top.next;
		}
		
		ltop.next = null; //remove any links
		
		
		return ltop;
		
	}
	
	public Node peek(){
		
		return top;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack stk = new Stack();
		Node nd = new Node(34);
		Node nd2 = new Node(2);
		Node nd3 = new Node(6);
		Node nd4 = new Node(90);
		Node nd5 = new Node(23);
		
		stk.push(nd2);
		stk.push(nd4);
		stk.push(nd5);
		
		System.out.println(stk.peek().data);
		stk.pop();
		stk.pop();
		System.out.println(stk.peek().data);
		
		
		
		
		

	}

}
