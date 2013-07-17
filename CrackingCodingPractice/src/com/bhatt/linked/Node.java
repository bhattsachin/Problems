package com.bhatt.linked;

public class Node {
	
	public Node next;
	public int data;
	
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
	
	public void append(Node node){
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
	
	/**
	 * next node
	 * @param curr
	 * @return
	 */
	public Node next(Node curr){
		return curr.next;
	}
	
	/**
	 *  Returns head
	 * @return
	 */
	public Node head(){
		return this;
	}
	
	public void deleteNext(Node curr){
		Node toDel = curr.next;
		if(toDel!=null){
			curr.next = toDel.next;
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

	public static void main(String args[]){
		
		Node nd = new Node(32);
		nd.append(34);
		nd.append(89);
		nd.append(76);
		nd.append(23);
		nd.append(12);
		
		
		nd.print();
		
		nd.deleteNext(nd);
		
		nd.print();
		
		
	}

}
