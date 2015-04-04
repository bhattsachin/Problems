package com.bhatt.graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.In;

public class NonRecursiveDFS {
	
	private boolean[] marked;
	Stack<Integer> stack;
	

	public NonRecursiveDFS(Graph h, Integer v) {
		marked = new boolean[h.V()];
		stack = new Stack<Integer>();
		stack.push(v);
		marked[v] = true;
		dfs(h);
	}

	private void dfs(Graph h){
		Integer v;
		
		while(!stack.isEmpty()){
			v = stack.pop();
			
			System.out.println(v);
			for(Integer a : h.adj(v)){
				if(!marked[a]){
					
					stack.push(a);
					marked[a] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
	    Graph G = new Graph(in);
	    int s = Integer.parseInt(args[1]);
		NonRecursiveDFS dfs = new NonRecursiveDFS(G,s);
		
	}

}
