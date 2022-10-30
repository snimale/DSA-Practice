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

public class HeapDSA {
	static int n1;
	
	public static void main(String args[]) {
		int[] heap1 = {9, 8, 1, 3, 5, 2, 34 , 3555, 5, 6};
		n1=10;
		heapSort(heap1);
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
	public static void insert(int[] heap, int k) {
		heap[n1] = k;
		n1++;
		int index = n1;
		while (index > 1) {
			int parent = index / 2;
			if (heap[index - 1] > heap[parent - 1]) {
				swap(heap, parent - 1, index - 1);
				index = parent;
			} else {
				return;
			}
		}

	}
	
	public static void heapify(int[] heap, int i) {
		int highest = i;
		int left = i*2;
		int right = (i*2)+1;
		if(left<=n1 && heap[left-1]>heap[highest-1]) {
			highest=left;
		}
		
		if(right<=n1 && heap[right-1]>heap[highest-1]) {
			highest=right;
		}
		if(highest!=i) {
			swap(heap, highest-1, i-1);
			heapify(heap, highest);
		}
		
	}
	
	public static void buildHeap(int[] arr) {
		// leaf node of complete exist from index i = n/2+1 to n, where n is the number elements in tree
		for(int i=n1/2; i>0; i--) {
			heapify(arr, i);
		}
	}
	
	public static void delete(int[] heap) {
		heap[0]=heap[n1-1];
		n1--;
		heap[n1]=0;
		heapify(heap, 1);
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
	
	public static void heapSort(int[] heap1) {
		buildHeap(heap1);
		int temp = n1;
		for(int i=n1; i>1; i--) {
			swap(heap1, i-1, 0);
			n1--;
			heapify(heap1, 1);
		}
		n1 = temp;
	}
	
}
