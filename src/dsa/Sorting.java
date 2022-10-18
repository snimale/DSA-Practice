package dsa;

public class Sorting {
	public static void main(String Args[]) {
		int[] arr = {1, 2, 3, 5, 7, 2, 4, 5, 7};
		bubbleSort(arr);
		for (int e : arr) {
			System.out.print(e +", ");
		}
	}
	public static void swap(int[] arr, int j) {
		arr[j]=arr[j]^arr[j+1];
		arr[j+1]=arr[j]^arr[j+1];
		arr[j]=arr[j]^arr[j+1];
	}
	public static void bubbleSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j);
				}
			}
		}
	}
}
