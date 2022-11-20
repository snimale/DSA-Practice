package easyQ;

import java.util.*;

public class PriorityQueueQ {
	public static void main(String args[]) {
		

		int[] a = {1,2,3};
		System.out.println(joiningRopeCost(a));
	
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
	
	// connect n ropes 2 at a time with minimum cost
	// cost of connecting any two rope is sum of length of both ropes
	
	public static int joiningRopeCost (int[] ropes) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int e : ropes) {
			pq.add(e);
		}
		
		int cost = 0;
		while (pq.size()>1) {
			int joined = pq.poll()+pq.poll();
			cost+=joined;
			pq.add(joined);
		}
		
		return cost;
	}
}
