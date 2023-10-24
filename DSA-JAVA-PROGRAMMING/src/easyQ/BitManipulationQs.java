package easyQ;

public class BitManipulationQs {
	public static void main(String args[]) {
		// to find the only element in an array that is not present as pair
		// properties used -> n^n = 0 and 0^n = n
		
		int[] arr = {1, 1, 3, 5, 6, 9, 3, 4, 4, 5, 6};
		int unpairedElement = 0; //initial value must be 0
		
		for(int e : arr) {
			unpairedElement = unpairedElement^e;
		}
		
		// System.out.println(unpairedElement);
	}
}
