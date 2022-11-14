package hardQ;

import java.util.*;
public class StackQ {
	public static void main(String args[]) {
		// To find previous smaller number/ its index i.e nearest small number w.r.t current number in array
		// Time Complexity - O(N) as we push and pop one element one time only
		int[] arrQ = {4, 5, 1, 3, 4, 2, 5, 9, 5, 2, 3, 1};
		int[] arrA = new int[arrQ.length];
		Deque<Integer> temp = new ArrayDeque<>(arrQ.length);
		
		for(int i=0; i<arrQ.length; i++) {
			while(!temp.isEmpty() && arrQ[temp.peek()]>=arrQ[i]) {
				temp.pop();
			}
			if(temp.isEmpty()) {
				arrA[i]=-1;
			} else {
				arrA[i]=temp.peek();
			}
			temp.push(i);
		}
		
		for(int i : arrA) {
			System.out.print(i+", ");
		}
	}
}
