package dsa;

import dsa.TreeDSA.Node;

public class BST {
	public static void main(String[] args) {
		int[] data = {20, 1, 99, 10, 100, 26, 834, 2, 111, 79, 69, 99};
		Node root = createBST(data);
		//inOrder(root);
		//deleteNode(root, new Node(1));
		inOrder(root);
	}
	
	public static Node createBST(int[] data) {
		if(data.length==0) return null;
		Node root = new Node(data[0]);
		for(int i=1; i<data.length; i++) root = insert(root, data[i]);
		return root;
	}
	
	public static Node insert(Node root, int data) {
		if(root==null) return new Node(data);
		if(data<root.data) root.left = insert(root.left, data);
		if(data>root.data) root.right = insert(root.right, data);
		return root;
	}
	
	private static Node nextInOrder(Node root) {
		if(root.left==null) return root;
		return nextInOrder(root.left);
	}
	
	public static Node deleteNode(Node root, Node noNeed) {
		if(root==null) return null;
		if(noNeed.data<root.data) {
			root.left = deleteNode(root.left, noNeed);
		}
		else if(noNeed.data>root.data) {
			root.right = deleteNode(root.right, noNeed);
		}
		else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else {
				root.data=nextInOrder(root).data;
				root.left=deleteNode(root.left, new Node(root.data));
			}
		}
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root==null) return;
		inOrder(root.left);
		System.out.printf("%d, ", root.data);
		inOrder(root.right);
	}
}
