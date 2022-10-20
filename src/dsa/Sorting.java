package dsa;

public class Sorting {
	public static void main(String Args[]) {
		int[] arr = {1, 2, 3, 5, 7, 2, 4, 5, 7};
		selectionSort(arr);
		for (int e : arr) {
			System.out.print(e +", ");
		}
	}
	public static void swap(int[] arr, int a, int b) {
		arr[a]=arr[a]^arr[b];
		arr[b]=arr[a]^arr[b];
		arr[a]=arr[a]^arr[b];
	}
	public static void bubbleSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		if (arr.length<2) {
			return;
		}
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
	
	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int min = i;
			for(int j=i+1; j<arr.length; j++) {
				if (arr[j]<arr[min]) {
					min=j;
				}
			}
			if(min!=i) {
				swap(arr, min, i);
			}
		}
	}
}
