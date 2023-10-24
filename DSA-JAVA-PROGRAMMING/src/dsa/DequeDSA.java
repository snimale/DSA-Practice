package dsa;

import java.util.*;

public class DequeDSA {
	public static void main(String args[]) {
		// double ended queue
		Deque<Integer> deq = new ArrayDeque<>();
		// move ele in deq
		deq.addFirst(2);
		deq.addLast(3);
		deq.offerFirst(1);
		deq.offerLast(4);
		
		// see next ele
		deq.getFirst();
		deq.getLast();
		deq.peekFirst();
		deq.peekLast();
		
		// remove next ele
		deq.pollFirst();
		deq.pollLast();
		deq.removeFirst();
		deq.removeLast();
		
		
		
		
		// deque used to make stack
		Deque<Integer> stack = new ArrayDeque<>(); // or implement using LinkedList
		stack.push(2);
		stack.peek();
		stack.pop();
		
		// deque used to make queue
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		queue.peek();
		queue.poll();
		
	}
}
