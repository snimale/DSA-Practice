package dsa;

import java.util.*;

public class PriorityQueueQ {
	public static void main(String args[]) {
		
		// find the k'th largest element
		int[] a = {1, 6, 7, 3, 4, 1, 4, 2, 6, 3};
		System.out.println(kthLargest(a, 2));
	
	}
	
	public static int kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<k; i++) {
			pq.add(arr[i]);
		}
		for(int i=k; i<arr.length; i++) {
			if(pq.peek()<arr[i]) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		return pq.peek();
	}
}
