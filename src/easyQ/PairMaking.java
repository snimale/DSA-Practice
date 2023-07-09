package easyQ;
import java.util.*;

public class PairMaking {
	public static void main(String args[]) {
		
	}
	
	public static void uniquePairs(List<Integer> arr) {
		// unique pairs means if (a, b) is taken then (b, a) can NOT be taken again
		// to do this we start nested loop from j = i to n
		for (int i=0; i<arr.size(); i++) {
			for (int j=i; j<arr.size(); j++) {
				// when we start from j = i, we avoid making (b, a) as a occurs before b and (a, b) is already traversed
			}
		}
	}
	
	public static void allPairs(List<Integer> arr) {
		// all pairs means if (a, b) is taken then (b, a) should also taken again
		// to do this we start nested loop from j = 0 to n
		for (int i=0; i<arr.size(); i++) {
			for (int j=0; j<arr.size(); j++) {
				// when we start from j = 0, we are making all possible pairs including (a, b) and (b, a) in it
			}
		}
	}
}
