package com.bhatt.linked;

/**
 * Add two numbers
 * @author bhatt
 *
 */
public class Four {
	
	public static int addTwoNumbers(Node num1, Node num2){
		int sum = getNumber(num1) + getNumber(num2);
		return sum;
	}
	
	public static int getNumber(Node num){
		Node curr = num;
		int val = 0;
		int count = 0;
		while(curr.next!=null){
			val = val + (int)Math.pow(10,count)*curr.data;
			curr = curr.next;
			count++;
		}
		
		val = val + (int)Math.pow(10,count)*curr.data;
		
		return val;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node nod1 = new Node(3);
		nod1.append(1);
		nod1.append(5);
		
		Node nod2 = new Node(5);
		nod2.append(9);
		nod2.append(2);
		
		System.out.println(addTwoNumbers(nod1, nod2));

	}

}
