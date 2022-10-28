package dsa;


class BinaryNode {
	int data;
	Node left;
	Node right;

	BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Heap {
	static int n1;
	
	public static void main(String args[]) {
		int[] heap1 = new int[15];
		for (int i = 0; i < 9; i++) {
			heap1[i] = 9 - i;
			n1++;
		}
		insert(heap1, 8);
		printHeap(heap1);
	}

	public static void swap(int[] arr, int a, int b) {
		if (arr[a]==arr[b]) {
			return;
		} else {
			arr[a]=arr[a]^arr[b];
			arr[b]=arr[a]^arr[b];
			arr[a]=arr[a]^arr[b];
		}
	}
	

	/*
	 * In java on calling a function, all changes done to non-primitive type
	 * arguments will be passed to the place where it is being called from,
	 * example is swap function where we don't even return swapped array but it
	 * is already changed in place it is called in but this does not happen in
	 * case of primitive arguments, i.e if you change a primitive argument in
	 * function, it wont be changed in the place where the function has been
	 * called from... so in short for primitive argument changes, the changes done
	 * in function will not be applied to the place where it was called from.
	 */	
	
	
	// insert element in heap
	public static void insert(int[] heap1, int k) {
		heap1[n1] = k;
		n1++;
		int index = n1;
		while (index > 1) {
			int parent = index / 2;
			if (heap1[index - 1] > heap1[parent - 1]) {
				swap(heap1, parent - 1, index - 1);
				index = parent;
			} else {
				return;
			}
		}

	}

	public static void printHeap(int[] heap) {
		int p = 1;
		int i = 0;
		while (i < n1) {
			for (int j = 0; j < p; j++) {
				if (i >= n1) {
					break;
				}
				System.out.print(heap[i] + ", ");
				i++;
			}
			System.out.println();
			p *= 2;
		}
	}
}
