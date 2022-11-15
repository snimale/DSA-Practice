package hardQ;

import java.util.*;
public class StackQ {
	public static void main(String args[]) {
		int[] arrQ = {4, 5, 1, 3, 4, 2, 5, 9, 5, 2, 3, 1};
		int[] ans1=psn(arrQ);
		int[] ans2=nsn(arrQ);
		System.out.println(Arrays.toString(ans1)+"\n"+Arrays.toString(ans2));
	}
	// To find previous smaller number/ its index i.e nearest small number on left side w.r.t current number in array
	// Time Complexity - O(N) as we push and pop one element one time only
	public static int[] psn(int[] arrQ) {
		int[] arrA1 = new int[arrQ.length];
		Deque<Integer> temp1 = new ArrayDeque<>(arrQ.length);
		for(int i=0; i<arrQ.length; i++) {
			while(!temp1.isEmpty() && arrQ[temp1.peek()]>=arrQ[i]) {
				temp1.pop();
			}
			if(temp1.isEmpty()) {
				arrA1[i]=-1;
			} else {
				arrA1[i]=temp1.peek();
			}
			temp1.push(i);
		}
		return arrA1;
	}
	
	
	// To find next smaller number/ its index i.e nearest small number on right side w.r.t current number in array
	// Time Complexity - O(N) as we push and pop one element one time only
	public static int [] nsn(int[] arrQ) {
		int[] arrA2 = new int[arrQ.length];
		Deque<Integer> temp2 = new ArrayDeque<>(arrQ.length);
		for(int i=arrQ.length-1; i>=0; i--) {
			while(!temp2.isEmpty() && arrQ[temp2.peek()]>=arrQ[i]) {
				temp2.poll();
			}
			if(temp2.isEmpty()) {
				arrA2[i]=arrQ.length;
			} else {
				arrA2[i]=temp2.peek();
			}
			temp2.push(i);
		}
		return arrA2;
	}
}
