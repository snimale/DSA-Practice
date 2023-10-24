package mediumQ;

import java.util.*;

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
		int[] ans = new int[15];
		int i=0;
		Queue<Node> q = new ArrayDeque<>();
		while(!(currNode.next==null) || !q.isEmpty()) {
			ans[i]=currNode.data;
			if(!(currNode.child==null)) {
				q.offer(currNode.child);
			}
			if(currNode.next==null) {
				currNode.next=q.poll();
			}
			currNode=currNode.next;
		}
	}
}
