package dsa;


class AStack {
	private int[] data;
	private int maxCapacity;
	private int index;
	
	public void push(int num) {
		if(index==maxCapacity-1) {
			System.out.println("what you doing bro");
		} else {
			data[++index] = num;
		}
	}
	
	public int peek() {
		if(index < 0) {
			return -1;
		} else {
			return data[index];
		}
	}
	
	public int pop() {
		if(index < 0) {
			return -1;
		} else {
			int temp = data[index];
			index--;
			return temp;
		}
		
	}
	
	public int size() {
		return index+1;
	}
	
	public boolean isEmpty() {
		if(index==-1) {
			return true;
		}
		return false;
	}
	
	public AStack(int n) {
		this.data = new int[n];
		this.maxCapacity = n;
		this.index = -1;
	}
}



class LLStack {
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	private Node head;
	
	public void push(int num) {
		Node newNode = new Node(num);
		newNode.next = head;
		head = newNode;
	}
	
	public int peek() {
		if(head==null) {
			System.out.println("Empty Stack");
			return -1;
		} else {
			return head.data;
		}
	}
	
	public int pop() {
		if(head==null) {
			System.out.println("Empty Stack");
			return -1;
		}
		int temp = head.data;
		head=head.next;
		return temp;
	}
	
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public LLStack() {
		head=null;
	}
}

public class StackDSA {
	public static void main(String args[]) {
		// to use stack data structure from collections
		// do not use Stack class to make stack object because this class uses indexing (it implements vector)
		// which is unnecessary in stack data structure
		// rather use Deque (pronounced as deck) interface using ArrayDeque/LinkedList constructor
		// Deque<Integer> s = new LinkedList<>();
		// Deque<Integer> s = new ArrayDeque<>();
	}
}
