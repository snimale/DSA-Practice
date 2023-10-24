package dsa;

import java.util.HashSet;

import dsa.TreeDSA.Node;

public class BST {
	public static void main(String[] args) {
		int[] data = {20, 1, 99, 10, 100, 26, 834, 2, 111, 79, 69, 99};
		Node root = createBST(data);
		//inOrder(root);
		//deleteNode(root, new Node(1));
		//System.out.println(checkBST(root));
		inOrder(root);
		//System.out.println("\n" + floorValue(root, 75) + " " + ceilValue(root, 75));
		//System.out.println(twosum(21, root));
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
	
	private static HashSet<Integer> hs = new HashSet<>();;
	public static boolean twosum(int sum, Node root) {
		return twosumUtil(sum, root);
	}
	
	public static boolean twosumUtil(int sum, Node root) {
		if(root==null) return false;
		if(hs.contains(sum - root.data)) return true;
		hs.add(root.data);
		return twosum(sum, root.right) || twosum(sum, root.left);
	}
	
	public static int floorValue(Node root, int reference) {
		return floorValueUtil(root, reference, Integer.MIN_VALUE);
	}
	
	public static int floorValueUtil(Node root, int reference, int currFloor) {
		if(root==null) return currFloor;
		if(root.data>reference) return floorValueUtil(root.left, reference, currFloor);
		else return floorValueUtil(root.right, reference, root.data);
	}
	
	public static int ceilValue(Node root, int reference) {
		return ceilValueUtil(root, reference, Integer.MAX_VALUE);
	}
	
	public static int ceilValueUtil(Node root, int reference, int currCeil) {
		if(root==null) return currCeil;
		if(root.data>reference) return ceilValueUtil(root.left, reference, root.data);
		else return ceilValueUtil(root.right, reference, currCeil);
	}
	
//	public static int getMax(Node root) {
//		if(root==null) return Integer.MIN_VALUE;
//		else return Math.max(Math.max(getMax(root.right), getMax(root.left)), root.data);
//	}
//	
//	public static int getMin(Node root) {
//		if(root==null) return Integer.MAX_VALUE;
//		else return Math.min(Math.min(getMin(root.right), getMin(root.left)), root.data);
//		
//	}
//	
//	public static boolean checkBST(Node root) {
//		if(root==null) return true;
//		if(getMax(root.left)<root.data && root.data<getMin(root.right)) return checkBST(root.left) && checkBST(root.right);
//		else return false;
//
//	}
	
	public static boolean checkBST(Node root) {
		return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean checkBSTUtil(Node root, int min, int max) {
		if(root==null) return true;
		else if(root.data>min && root.data<max)	{
			return checkBSTUtil(root.left, Integer.MIN_VALUE, root.data) && checkBSTUtil(root.right, root.data, Integer.MAX_VALUE);
		}
		return false;
	}
	
	public static void inOrder(Node root) {
		if(root==null) return;
		inOrder(root.left);
		System.out.printf("%d, ", root.data);
		inOrder(root.right);
	}
}
