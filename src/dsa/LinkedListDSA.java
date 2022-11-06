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
			this.addAtFront(data);
		} else if (index==size) {
			this.addAtEnd(data);
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
				size--;
			} else {
				Node currNode = head;
				while(currNode.next.next!=null) {
					currNode=currNode.next;
				}
				currNode.next=null;
				tail=currNode;
				size--;
			}
		}
	}
	
	public void remove(int index) {
		if(index<0 || index>=size) {
			System.out.println("Invalid index");
		} else if (index==0) {
			this.removeFromFront();
		} else if (index==size-1) {
			this.removeFromLast();
		} else {
			Node currNode = head;
			for(int i=1; i<index; i++) {
				currNode=currNode.next;
			}
			currNode.next=currNode.next.next;
			size--;
		}
	}
	
	//reverse linked list with loop
	public static LinkedList reverseLinkedListLoop(LinkedList list) {
		if (list.size==1 || list.size==0) {
			return list;
		} else {
			Node pn = null;
			Node cn = list.head ;
			while(cn!=null) {
				Node nn = cn.next;
				cn.next = pn;
				pn =cn;
				cn = nn;
			}
			list.tail=list.head;
			list.head = pn;
			return list;
		}
	}
	
	//reverse linked list with recursion
	public static LinkedList reverseLinkedListRecursion(LinkedList list) {
		list.tail=list.head;
		list.head=reverseLinkedListRecursionNode(list.head);
		return list;
	}
	private static Node reverseLinkedListRecursionNode(Node currNode) {
		if(currNode==null) {
			return null;
		}
		
		if (currNode.next==null) {
			return currNode;
		}
		Node newHead = reverseLinkedListRecursionNode(currNode.next);
		currNode.next.next=currNode;
		currNode.next=null;
		return newHead;
	}
	
	//change data
	public void set(int index, int data) {
		if(index<0 || index>=size) {
			System.out.println("Invalid index");
		} else {
			Node currNode = head;
			for(int i=0; i<index; i++) {
				currNode=currNode.next;
			}
			currNode.data=data;
		}
	}
	
	// check if cycle exists
	public static Node checkCycle(LinkedList list) {
		if(list.head==null || list.head.next==null) {
			return null;
		}
		Node fast = list.head.next.next;
		Node slow = list.head.next;

		while(fast!=null && fast.next!=null) {
			if(fast.data==slow.data) {
				return slow;
			}
			fast=fast.next.next;
			slow=slow.next;
			
		}
		return null;
	}
	
	// get origin of cycle in linked list
	public static Node cycleOrigin(LinkedList list) {
		Node meet = checkCycle(list);
		Node currNode = list.head;
		if(meet==null) {
			return null;
		}
		while(meet.data!=currNode.data){
			meet=meet.next;
			currNode=currNode.next;
			// they will always coincide at origin on cycle
		}
		return meet;
	}
	
	// remove cycle in linked list
	public static void removeCycle(LinkedList list) {
		Node meet = checkCycle(list);
		Node prev = null;
		Node currNode = list.head;
		if(meet==null) {
			return;
		}
		while(meet.data!=currNode.data) {
			prev=meet;
			meet=meet.next;
			currNode=currNode.next;
		}
		prev.next=null;
	}
	
	//getters -> head, tail, size, string of elements
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public int get(int index) {
		if(index<0 || index>=size) {
			System.out.println("Invalid index");
			return -1;
		} else {
			Node currNode = head;
			for(int i=0; i<index; i++) {
				currNode=currNode.next;
			}
			return currNode.data;
		}
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
		for(int i=0; i<6; i++) {
			list.addAtEnd(i+1);
		}
		System.out.println(list);
		
		list.getTail().next=list.getHead().next.next;
		LinkedList.removeCycle(list);
		System.out.println(list);
		 
	}
}
