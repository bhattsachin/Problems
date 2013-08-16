package com.bhatt.lca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LCA {
	
	static BTreeNode head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createTree();
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    int num1, num2;
	    while ((line = in.readLine()) != null) {
	        String[] lineArray = line.split(" ");
	        if (lineArray.length == 2) {
	            num1 = Integer.parseInt(lineArray[0]);
	            num2 = Integer.parseInt(lineArray[1]);
	            head.traverse(num1, num2);
	        }
	    }
		
		}catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
		//head.traverse(3,  45);
		// TODO Auto-generated method stub

	}
	
	public static void createTree(){
		
		BTreeNode leaf1 = new BTreeNode(10, null, null);
		BTreeNode leaf2 = new BTreeNode(29, null, null);
		BTreeNode node1 = new BTreeNode(20, leaf1, leaf2);
		BTreeNode leaf3 = new BTreeNode(3, null, null);
		BTreeNode node2 = new BTreeNode(8, leaf3, node1);
		BTreeNode leaf4 = new BTreeNode(52, null, null);
		head = new BTreeNode(30, node2, leaf4);
	}
	
	
	
	
	

}


class BTreeNode{
	public BTreeNode left;
	public BTreeNode right;
	public int val;
	
	public BTreeNode(int val, BTreeNode left, BTreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public boolean traverse(int num1, int num2){
		boolean result = false;
		boolean leftResult = false;
		boolean rightResult = false;
		//if my left and right returns true. i print the value and return false
		if(this.val!=num1 && this.val!=num2){
			if(this.left!=null){
				leftResult = this.left.traverse(num1, num2);
			}
			
			if(this.right!=null){
				rightResult = this.right.traverse(num1, num2);
			}
			
			if(leftResult&&rightResult){
				System.out.println(this.val);
				result = false;
			}else if(leftResult || rightResult){
				result = true;
			}
			
			return result;
		}
		
		if(this.val==num1 || this.val==num2){
			//go through the kids and see if any other value matches under same
			if(this.left!=null){
				leftResult = this.left.traverse(num1, num2);
			}
			
			if(this.right!=null){
				rightResult = this.right.traverse(num1, num2);
			}
			
			if(leftResult || rightResult){
				System.out.println(this.val);
				result = false;
			}else{
				result = true;
			}
			
			return result;
			
		}
		
		
		
		
		return false;
	}
	
}
