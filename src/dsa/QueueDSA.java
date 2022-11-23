package dsa;



class LLQueue {
	LinkedList queue;
	int size;
	
	public void enqueue(int e) {
		queue.addAtEnd(e);
	}
	
	public int dequeue() {
		int e = queue.getHead().data;
		queue.removeFromFront();
		return e;
	}
	
	public int peek() {
		if(queue.isEmpty()) {
			return -1;
		}
		return queue.getHead().data;
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public LLQueue() {
		this.queue=new LinkedList();
		this.size=0;
	}
}

class AQueue {
	int[] queue;
	int capacity;
	int endi;
	
	public void enqueue(int e) {
		if(endi+1==capacity) {
			System.out.println("error : OverFlow");
			return;
		}
		endi++;
		queue[endi]=e;
	}
	
	public int dequeue() {
		if(endi==-1) {
			System.out.println("error : UnderFlow");
			return -1;
		}
		int e = queue[0];
		for(int i=0; i<endi; i++) {
			queue[i]=queue[i+1];
		}
		endi--;
		return e;
		
	}
	
	public int peek() {
		if(endi==-1) {
			return -1;
		}
		return queue[endi];
	}
	
	public int size() {
		return endi+1;
	}
	
	public boolean isEmpty() {
		if(endi==-1) {
			return true;
		}
		return false;
	}
	
	public AQueue(int n) {
		this.queue= new int[n];
		this.capacity=n;
		endi=-1;
	}
}
public class QueueDSA {

}
