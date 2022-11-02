package dsa;

import java.util.*;

public class PriorityQueueQ {
	public static void main(String args[]) {
		

		int[] a = {1, 10, 15, 40, 9, 20, 77, 4, 55};
		System.out.println(kthsmallest(a, 2));
	
	}
	
	// find the k'th largest element
	public static int kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		for(int i=0; i<k; i++) {
			pq1.add(arr[i]);
		}
		for(int i=k; i<arr.length; i++) {
			if(pq1.peek()<arr[i]) {
				pq1.poll();
				pq1.add(arr[i]);
			}
		}
		return pq1.peek();
	}
	
	// find the k'th smallest element
	public static int kthsmallest(int[] arr, int k) {
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<k; i++) {
			pq2.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(pq2.peek()>arr[i]) {
				pq2.poll();
				pq2.add(arr[i]);
			}
		}
		return pq2.peek();
	}
}
