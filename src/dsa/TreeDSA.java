package dsa;
import java.util.*;
import java.util.Map.Entry;
public class TreeDSA {
	public static void main(String args[]) {
		Node root = createTree();
		bottomView(root);
		//rightView(root);
		//leftView(root);
		//System.out.println(height(root));
		//System.out.println(height(root));
		//System.out.println(max(root));
		//System.out.println(min(root));
		
	}
	
	static class PairComparator implements Comparator<Pair> {
	
		@Override
		public int compare(Pair p1, Pair p2) {
			if(p1.column>p2.column) return 1;
			else if(p1.column<p2.column) return -1;
			else return 0;
		}
		
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	static class Pair {
		Node node;
		int column;
		Pair(Node node, int column) {
			this.node=node;
			this.column=column;
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
		System.out.println("Enter left of"+e);
		newNode.left=createTree();
		System.out.println("Enter right of"+e);
		newNode.right=createTree();
		return newNode;
		
	}
	
	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node currNode=q.poll();
			if(currNode==null) {
				if(q.isEmpty()) break;
				System.out.println();
				q.add(null);
				continue;
			}
			System.out.print(currNode.data);
			if(currNode.left!=null) {
				q.add(currNode.left);
			}
			if(currNode.right!=null) {
				q.add(currNode.right);
			}
		}
	}
	private static void leftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		boolean left=true;
		while(!q.isEmpty()) {
			Node currNode=q.poll();
			if(left==true) {
				System.out.print(currNode.data+"\n"); 
				left=false;
			}
			if(currNode==null) {
				if(q.isEmpty()) break;
				q.add(null);
				left=true;
			} else {
				if(currNode.left!=null) q.add(currNode.left);
				if(currNode.right!=null) q.add(currNode.right);
			}
		}
	}
	public static void rightView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node currNode=q.poll();
			if(currNode==null) {
				if(q.isEmpty()) break;
				else q.add(null);
			} else {
				if(q.peek()==null) {
					System.out.print(currNode.data+"\n"); 
				}
				if(currNode.left!=null) q.add(currNode.left);
				if(currNode.right!=null) q.add(currNode.right);
			}
		}
	}
	public static void topView(Node root) {
		HashMap<Integer, Pair> topView= new HashMap<>();
		Pair head = new Pair(root, 0);
		Queue<Pair> q = new LinkedList<>();
		q.add(head);
		q.add(null);
		while(!q.isEmpty()) {
			Pair currPair = q.poll();
			if(currPair==null) {
				if(q.isEmpty()) break;
				else q.add(null);
			} else {
				if (!topView.containsKey(currPair.column)) topView.put(currPair.column, currPair);
				if(currPair.node.left!=null) q.add(new Pair(currPair.node.left, currPair.column-1));
				if(currPair.node.right!=null) q.add(new Pair(currPair.node.right, currPair.column+1));
			}
		}
		ArrayList<Pair> myList = new ArrayList<>();
		myList.addAll(topView.values());
		Collections.sort(myList, new PairComparator());
		System.out.println("Top View = ");
		for(Pair p : myList) {
			System.out.print(p.node.data+" - ");
		}
	}
	public static void bottomView(Node root) {
		HashMap<Integer, Pair> bottomView= new HashMap<>();
		Pair head = new Pair(root, 0);
		Queue<Pair> q = new LinkedList<>();
		q.add(head);
		q.add(null);
		while(!q.isEmpty()) {
			Pair currPair = q.poll();
			if(currPair==null) {
				if(q.isEmpty()) break;
				else q.add(null);
			} else {
				bottomView.put(currPair.column, currPair);
				if(currPair.node.left!=null) q.add(new Pair(currPair.node.left, currPair.column-1));
				if(currPair.node.right!=null) q.add(new Pair(currPair.node.right, currPair.column+1));
			}
		}
		ArrayList<Pair> myList = new ArrayList<>();
		myList.addAll(bottomView.values());
		Collections.sort(myList, new PairComparator());
		System.out.println("Bottom View = ");
		for(Pair p : myList) {
			System.out.print(p.node.data+" - ");
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

