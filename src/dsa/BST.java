package dsa;

import dsa.TreeDSA.Node;

public class BST {
	public static void main(String[] args) {
		int[] data = {20, 1, 99, 10, 100, 26, 834, 2, 111, 79, 69, 99};
		Node root = createBST(data);
		preorder(root);
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
	
	public static void preorder(Node root) {
		if(root==null) return;
		preorder(root.left);
		System.out.printf("%d, ", root.data);
		preorder(root.right);
	}
}
