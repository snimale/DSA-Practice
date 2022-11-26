package mediumQ;
import java.util.*;

//IMPLEMENT STACK USING QUEUE
class QStack {
	Queue<Integer> q1;
	Queue<Integer> q2;
	
	public QStack() {
		this.q1=new LinkedList<Integer>();
		this.q2=new LinkedList<Integer>();
	}
	
	public void push(int num) {
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		q1.add(num);
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}
	
	public int peek() {
		return q1.peek();
	}
	
	public int poll() {
		return q1.poll();
	}
}
//IMPLEMENT QUEUE USING STACK
class SQueue {
	Deque<Integer> s2;
	Deque<Integer> s1;
	
	public SQueue() {
		this.s1= new LinkedList<Integer>();
		this.s2= new LinkedList<Integer>();
	}
	
	public void offer(int num) {
		s1.add(num);
	}
	
	public int peek() {
		while(!s1.isEmpty()) {
			s2.push(s1.poll());
		}
		int temp = s2.peek();
		while(!s2.isEmpty()) {
			s1.push(s2.poll());
		}
		return temp;
	}
	
	public int poll() {
		while(!s1.isEmpty()) {
			s2.push(s1.poll());
		}
		int temp = s2.poll();
		while(!s2.isEmpty()) {
			s1.push(s2.poll());
		}
		return temp;
	}
	
}

public class QueueStackQ {
	
}
