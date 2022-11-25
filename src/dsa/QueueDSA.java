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
		return queue[0];
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
		this.endi=-1;
	}
}

class CAQueue {
	int[] queue;
	int s;
	int e;
	int size;
	
	public void enqueue(int num) {
		if((e+1)%queue.length==s) {
			System.out.println("Error : OverFlow");
			return;
		} else if (s==-1 && e==-1) {
			s++;
			e++;
			queue[e]=num;
			return;
		}
		e=(e+1)%queue.length;
		queue[e]=num;
		return;
	}
	
	public int dequeue() {
		if(s==-1 && e==-1) {
			return -1;
		} else if (s==e) {
			int temp = queue[s];
			s=-1;
			e=-1;
			return temp;
		}
		
		int temp = queue[s];
		s=(s+1)%queue.length;
		return temp;
	}
	
	public int peek() {
		if(s==-1 && e==-1) {
			return -1;
		}
		return queue[s];
	}
	
	public boolean isEmpty() {
		if(s==-1 && e==-1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	
	public CAQueue(int capacity) {
		this.queue = new int[capacity];
		this.s=-1;
		this.e=-1;
		this.size=0;
	}
}
public class QueueDSA {

}
