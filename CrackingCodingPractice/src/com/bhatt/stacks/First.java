package com.bhatt.stacks;

/**
 * Single array to implement 3 stacks.
 * 
 * @author bhatt
 *
 */
public class First {
	
	StackNode[] baseArray = new StackNode[100];
	int[] stackPointer = {-1,-1,-1};
	int counter;
	
	
	public void push(int stack, int value){
		StackNode node = new StackNode(value, stackPointer[stack]);
		stackPointer[stack] = counter++;
		baseArray[stackPointer[stack]] = node;
		
		
	}
	
	public int pop(int stack){
		if((stackPointer[stack])==-1) return -1;
		StackNode node = baseArray[stackPointer[stack]];
		stackPointer[stack] = node.next;
		
		
		return node.value;
	}
	
	public int peek(int stack){
		if((stackPointer[stack])==-1) return -1;
		StackNode node = baseArray[stackPointer[stack]];
		
		return node.value;
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		First first = new First();
		first.push(0, 23);
		first.push(0, 45);
		first.push(1, 4);
		first.push(2, 90);
		first.push(1, 87);
		
		System.out.println(first.peek(0));
		System.out.println(first.peek(1));
		System.out.println(first.peek(2));
		
		first.pop(0);
		first.pop(1);
		first.pop(2);
		System.out.println("------------");
		System.out.println(first.peek(0));
		System.out.println(first.peek(1));
		System.out.println(first.peek(2));
		
	}
	
	
	
	class StackNode{
		int next;
		int value;
		public StackNode(int val, int nxt){
			this.next = nxt;
			this.value = val;
		}
	}

}
