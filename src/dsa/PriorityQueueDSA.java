package dsa;

import java.util.*;
public class PriorityQueueDSA {
	public static void main(String args[]) {
		// by default PriorityQueue uses MinHeap and priority is given to minimum Integer
		// if you want maximum or custom priority, you have to pass a comparator function in constructor of PriorityQueue
		// use Collections.reverseOrder comparator to convert given default MinHeap to MaxHeap
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(5);
		pq.add(7);
		pq.add(3);
		pq.add(9);
		System.out.println(pq);
		System.out.println(pq.peek());
		pq.poll();
		System.out.println(pq);

	}
}
