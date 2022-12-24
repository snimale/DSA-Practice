package dsa;
import java.util.*;
public class TreeDSA {
	public static void main(String args[]) {
		Node root = createTree();
		levelOrder(root);
		//System.out.println(height(root));
		//System.out.println(max(root));
		//System.out.println(min(root));
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	public static Node createTree() {
		System.out.print("Enter Element - ");
		int e = sc.nextInt();
		if(e==-1) {
			return null;
		}
		Node newNode = new Node(e);
		System.out.println("\nEnter left of"+e);
		newNode.left=createTree();
		System.out.println("\nEnter right of"+e);
		newNode.right=createTree();
		return newNode;
		
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node currNode=q.poll();
			System.out.print(currNode.data);
			if(currNode.left!=null) {
				q.add(currNode.left);
			}
			if(currNode.right!=null) {
				q.add(currNode.right);
			}
		}
	}
	public static void preOrder(Node root) {
		if(root==null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root) {
		if(root==null) return;
		preOrder(root.left);
		System.out.println(root.data);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root==null) return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.println(root.data);
	}
	
	public static int height(Node root) {
		if(root==null) return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	public static int max(Node root) {
		if(root==null) return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
	}
	
	public static int min(Node root) {
		if(root==null) return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
		
	}
}

