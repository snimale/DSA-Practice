package hardQ;

import java.util.*;
public class StackQ {
	public static void main(String args[]) {
		int[] arrQ = {4, 5, 1, 3, 4, 2, 5, 9, 5, 2, 3, 1};
		int[] ans1=psni(arrQ);
		int[] ans2=nsni(arrQ);
		int[] ans3=plni(arrQ);
		int[] ans4=nlni(arrQ);
		int la = largestAreaInHistogram(arrQ);
		System.out.println(Arrays.toString(ans1)+"\n"+Arrays.toString(ans2)+"\n"+Arrays.toString(ans3)+"\n"+Arrays.toString(ans4));
		System.out.println(la);
	}
	// To find previous smaller number/ its index i.e nearest small number on left side w.r.t current number in array.
	// Time Complexity - O(N) as we push and pop one element one time only.
	public static int[] psni(int[] arrQ) { // previous smaller number index
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
	
	
	// To find next smaller number/ its index i.e nearest small number on right side w.r.t current number in array.
	// Time Complexity - O(N) as we push and pop one element one time only.
	public static int [] nsni(int[] arrQ) { // next smaller number index
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
	
	// To find previous larger number/ its index i.e nearest large number on left side w.r.t current number in array.
	// Time Complexity - O(N) as we push and pop one element one time only.
	public static int[] plni(int[] arrQ) { //previous larger number index
		int[] arrA3 = new int[arrQ.length];
		Deque<Integer> temp3 = new ArrayDeque<>(arrQ.length);
		for(int i=0; i<arrQ.length; i++) {
			while(!temp3.isEmpty() && arrQ[temp3.peek()]<=arrQ[i]) {
				temp3.pop();
			}
			if(!temp3.isEmpty()) {
				arrA3[i]=temp3.peek();
			} else {
				arrA3[i]=-1;
			}
			temp3.push(i);
		}
		return arrA3;
	}
	
	// To find next larger number/ its index i.e nearest large number on right side w.r.t current number in array.
	// Time Complexity - O(N) as we push and pop one element one time only.
	public static int[] nlni(int[] arrQ) { // next larger number index
		int[] arrA4 = new int[arrQ.length];
		Deque<Integer> temp4 = new ArrayDeque<>(arrQ.length);
		for(int i=arrQ.length-1; i>=0; i--) {
			while(!temp4.isEmpty() && arrQ[temp4.peek()]<=arrQ[i]) {
				temp4.pop();
			}
			if(temp4.isEmpty()) {
				arrA4[i]=arrQ.length;
			} else {
				arrA4[i]=temp4.peek();
			}
			temp4.push(i);
		}
		return arrA4;
	}
	
	// to find largest area in a histogram
	public static int largestAreaInHistogram(int[] arrQ) {
		// largest area in histogram will be height of some column * its max possible width across histogram.
		// we need find nearest smaller element on left and right of current column to find its max width possible.
		int[] leftEnd = psni(arrQ);
		int[] rightEnd = nsni(arrQ);
		int largestArea=0;
		for(int i=0; i<arrQ.length; i++) {
			int tempArea = arrQ[i]*(rightEnd[i]-leftEnd[i]-1); // -1 is needed be careful
			if(largestArea<tempArea) {
				largestArea=tempArea;
			}
		}
		return largestArea;
	}
}
