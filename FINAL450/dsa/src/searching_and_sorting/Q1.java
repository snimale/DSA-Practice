package searching_and_sorting;
import java.util.Scanner;

public class Q1 {
	public static void main(String args[]) {
		// Find first and last positions of an element in a sorted array
		/* Test Case:
		 * 1 3 5 5 5 5 67 123 125 150 5
		 * */
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		for(int i=0; i<10; i++) arr[i] = sc.nextInt();
		int x = sc.nextInt();
		int present_index = binary_search(arr, 0, arr.length-1, x);
		if(present_index == -1) System.out.println("\nElement Not In Array!\n");
		else {
			int left_index=present_index, right_index=present_index;
			int temp = left_index;
			while(temp!=-1) {
				left_index = temp;
				temp = binary_search(arr, 0, left_index-1, x);
			}
			temp = right_index;
			while(temp!=-1) {
				right_index = temp;
				temp = binary_search(arr, right_index+1, arr.length-1, x);
			} System.out.println("First and Last Position of ele: "+left_index+", "+right_index);
		}
		sc.close();
	}
	
	private static int binary_search(int arr[], int a, int b, int x) {
		if(a>b) return -1;
		else if(a==b) {
			if(arr[a]==x) return a;
			else return -1;
		} else {
			int mid = a + (b-a)/2;
			if(arr[mid]==x) return mid;
			else if(x>arr[mid]) return binary_search(arr, mid+1, b, x);
			else return binary_search(arr, a, mid-1, x);
		}
	}
}
