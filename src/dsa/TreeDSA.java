package dsa;
import java.util.*;
import java.util.Map.Entry;
public class TreeDSA {
	public static void main(String args[]) {
		System.out.println("Enter InOrder array representing tree");
		Node root = createTree();
		// sample tree -> 1 2 3 4 5 -1 -1 -1 6 -1 -1 7 8 -1 -1 9 10 -1 -1 -1 11 -1 12 15 -1 16 17 -1 -1 -1 13 -1 14 -1 -1
		//System.out.println(diameter(root));
		//printFlattenTree(flatten(root));
		//bottomView(root);
		//rightView(root);
		//leftView(root);
		//System.out.println(height(root));
		//System.out.println(height(root));
		//System.out.println(max(root));
		//System.out.println(min(root));
		//System.out.println(timeToBurnTree(root, 6, 0));
		System.out.println(lowestCommonAncestor(root, new Node(8), new Node(9)));
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
		
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
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
		int e = sc.nextInt();
		if(e==-1) {
			return null;
		}
		Node newNode = new Node(e);
		newNode.left=createTree();
		newNode.right=createTree();
		return newNode;
		
	}
	
	static Node head = null;
	static Node previous = null;
	public static void flatten1(Node root) {
		if(root==null) return;
		flatten1(root.left);
		if(head==null && previous==null) {
			head=root;
		} else {
			root.left=previous;
			previous.right=root;	
		}
		previous=root;
		flatten1(root.right);
	}
	
	public static Node flatten(Node root) {
		head = null;
		previous = null;
		flatten1(root);
		return head;
			
	}
	
	public static void printFlattenTree(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" -> ");
			temp=temp.right;
		}
		System.out.println("null");
		temp=head;
		System.out.print("null");
		while(temp!=null) {
			System.out.print(temp.data+" <- ");
			temp=temp.right;
		}

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
	
	public static boolean containsNode(Node root, int Target) {
		if(root==null) return false;
		if(root.data==Target) return true;
		return containsNode(root.left, Target) || containsNode(root.right, Target);
	}
	public static int timeToBurnTree(Node root, int burner, int farness) {
		if(root==null) return 0;
		if(root.data==burner) return Math.max(height(root), farness+1);
		if(containsNode(root.left, burner)) return timeToBurnTree(root.left, burner, Math.max(farness+1, height(root.right)+1));
		else return timeToBurnTree(root.right, burner, Math.max(farness+1, height(root.left)+1));
	}
	
	public static Node lowestCommonAncestor(Node root, Node a, Node b) {
		if(root==null) return null;
		if(root.data==a.data || root.data==b.data) return root;
		else if ((containsNode(root.left, a.data) && containsNode(root.left, b.data))) return lowestCommonAncestor(root.left, a, b);
		else if ((containsNode(root.right, a.data) && containsNode(root.right, b.data))) return lowestCommonAncestor(root.right, a, b);
		return root;
	}
//	public static Node makeBST(Node root) {
//		
//	}
//	
	public static int height(Node root) {
		if(root==null) return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	public static int diameter(Node root) {
		if(root==null) return 0;
		return Math.max(height(root.left)+height(root.right)+1, Math.max(diameter(root.left), diameter(root.right)));
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

