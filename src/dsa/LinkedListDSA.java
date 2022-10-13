package dsa;

class Node {
	int data;
	Node next;
	Node (int data) {
		this.data=data;
		this.next=null;
	}
}

class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	
	//add functions
	public void addAtFront (int data) {
		Node newNode = new Node(data);
		if (head==null&&tail==null) {
			head=newNode;
			tail=newNode;
		} else {
			newNode.next=head;
			head=newNode;
		}
		size++;
	}

	public void addAtEnd (int data) {
		Node newNode = new Node(data);
		if (head==null&&tail==null) {
			head=newNode;
			tail=newNode;
		} else {
			tail.next=newNode;
			tail=tail.next;
		}
		size++;
	}
	
	public void add(int index, int data) {
		if (index<0 || index>size) {
			System.out.println("Invaild Index");
		} else if (index==0) {
			addAtFront(data);
		} else if (index==size) {
			addAtEnd(data);
		} else {
			Node newNode = new Node(data);
			Node currNode = head; //0 index start
			for (int i=1; i <size; i++) {
				if (i==index) {
					Node nextNode = currNode.next;
					currNode.next = newNode;
					currNode.next.next = nextNode;
					size++;
					break;
				} else {
					currNode = currNode.next;
				}
			}
			
		}
	}
	
	
	//remove functions
	public void removeFromFront() {
		if(head==null&&tail==null) {
			System.out.println("Nothing to remove");
		} else {
			head=head.next;
			size--;
			if(head==null) {
				tail=null;
			}
		}
	}
	
	public void removeFromLast() {
		if(head==null&&tail==null) {
			System.out.println("Nothing to Remove");
		} else {
			if (head.next==null) {
				head=null;
				tail=null;
			} else {
				Node currNode = head;
				while(currNode.next.next!=null) {
					currNode=currNode.next;
				}
				currNode.next=null;
				tail=currNode;
			}
		}
	}
	
	//getters -> head, tail, size, string of elements
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		Node currNode = head;
		while(currNode!=null) {
			str.append(currNode.data+" -> ");
			currNode=currNode.next;
		}
		str.append("Null");
		return str.toString();
	}
	
	
	//constructor
	LinkedList () {
		this.size=0;
		this.head=null;
		this.tail=null;
	}
}

public class LinkedListDSA {
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.addAtFront(1);
		list.addAtFront(2);
		list.addAtEnd(4);
		list.add(2, 3);
		
		//add remove at index i at next commit
	}
}
