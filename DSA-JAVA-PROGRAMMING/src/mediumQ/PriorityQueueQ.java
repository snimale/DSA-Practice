package mediumQ;

import java.util.*;

public class PriorityQueueQ {
	
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	public static void main(String args[]) {
		// find median of live running stream of numbers
		// over all time complexity O(n*log(n)) - n elements, each element take O(log(n)) to insert
	}
	
	public static void insertNum(int num) {
		// time complexity -> O(log(n))
		
		if(maxHeap.isEmpty()) {
			maxHeap.add(num);
			return;
		} else {
			if(maxHeap.peek()>num) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
		
		if(maxHeap.size()>minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
		} else if(maxHeap.size()<minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}
	
	public static int getMedian() {
		// time complexity -> O(1)
		if(maxHeap.size()==minHeap.size()) {
			return maxHeap.peek() + (minHeap.peek()-maxHeap.peek())/2;
		} else {
			return maxHeap.peek();
		}
	}
}
