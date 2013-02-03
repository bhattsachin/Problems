package com.bhatt.stacks;

import com.bhatt.linked.Node;

/**
 * Sort items in a stack
 * 
 * @author bhatt
 * 
 */
public class Six {

	static Stack aux = new Stack();
	static Stack orig = new Stack();

	/**
	 * 
	 */
	public void sort() {

		origToAux();
		int count = auxToOrig();
		while (count > 0) {
			count = auxToOrig();
		}

	}

	/**
	 * 
	 */
	public void origToAux() {
		Node nd = null;
		Node held = null;
		Node bet = null;
		while (orig.peek() != null) {
			nd = orig.pop();
			nd.next = null;
			aux.push(nd);
		}

	}

	/**
	 * 
	 * @return
	 */
	public int auxToOrig() {
		Node nd = null;
		Node held = null;
		Node bet = null;
		int pushcounter = 0;
		int countremain = 0;
		held = aux.pop();
		while (aux.peek() != null) {
			nd = aux.pop();
			if (held.data < nd.data) {
				bet = held;
				held = nd;
				held.next = null;
				nd = bet;
			}
			orig.push(nd);
			pushcounter++;
		}
		countremain = pushcounter;
		while (pushcounter > 0) {
			nd = orig.pop();
			aux.push(nd);
			pushcounter--;
		}
		// nowpushthebigguy
		orig.push(held);
		return countremain;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Six six = new Six();

		orig.push(new Node(34));
		orig.push(new Node(44));
		orig.push(new Node(24));
		orig.push(new Node(31));
		orig.push(new Node(84));
		orig.push(new Node(14));

		six.sort();

		for (int i = 0; i < 6; i++)
			System.out.println(orig.pop().data);

	}

}
