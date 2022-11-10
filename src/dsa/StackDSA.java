package dsa;

import java.util.Stack;

class AStack {
	private int[] data;
	private int maxCapacity;
	private int index;
	
	public void push(int num) throws Exception {
		if(index==maxCapacity-1) {
			throw new Exception("what you doing bro");
		} else {
			index++;
			data[index] = num;
		}
	}
	
	public int peek() {
		if(index < 0) {
			return -1;
		} else {
			return data[index];
		}
	}
	
	public int pop() {
		if(index < 0) {
			return -1;
		} else {
			int temp = data[index];
			index--;
			return temp;
		}
		
	}
	
	public int size() {
		return index+1;
	}
	
	public boolean isEmpty() {
		if(index==-1) {
			return true;
		}
		return false;
	}
	
	public AStack(int n) {
		this.data = new int[n];
		this.maxCapacity = n;
		this.index = -1;
	}
}
public class StackDSA {
	public static void main(String args[]) {
		Stack<Integer> s1 = new Stack<>();
		for(int i=1; i<4; i++) {
			s1.push(i);
			System.out.println(s1.peek());
		}
		System.out.println("size -> " + s1.size());
	}
}
