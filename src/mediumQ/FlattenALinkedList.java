package mediumQ;

class Node {
	int data;
	Node next;
	Node child;
	Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}
public class FlattenALinkedList {
	public static void main(String args[]) {
		Node head = new Node(1);
		Node currNode = head;
		for(int i=2; i<6; i++) {
			currNode.next = new Node(i);
			currNode=currNode.next;
		}
		currNode=head;
		while(currNode!=null) {
			System.out.println(currNode.data);
			currNode=currNode.next;
		}
	}
}
