package mediumQ;
import java.util.*;

public class FibonachiiSearch{
	private static List<Integer> memo;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(sc.nextInt());
		} 
		// PRINT NOT SORTED
		printList(list);
		
		// SORT
		Collections.sort(list);
		
		// PRINT SORTED
		printList(list);
		
		// CHECK IF FIB WORK
		//System.out.println(fib(100));
		
		// SEARCH
		int s = sc.nextInt();
		fibSearch(list, s);
	}
	
	private static void printList(List<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print( list.get(i) + " ");
		} System.out.println();
	}
	
	private static void fibSearch(List<Integer> list, int s) {
		int k = 0;
		memo = new ArrayList<>(list.size());
		while(fib(k)<=list.size()) {
			k++;
		}
		fibSearch_util(list, s, k, -1);
	}
	
	private static void fibSearch_util(List<Integer> list, int s, int k, int offset) {
		int i = offset+fib(k-2), 
	}
	
	private static int fib(int k) {
		// returns kth fib number
		if(k<=0) return 0;
		if(k==1) return 1;
		if(k<memo.size() && memo.get(k)!=0) return memo.get(k);
		else {
			int curr = fib(k-1) + fib(k-2);
			if(k<memo.size()) memo.set(k, curr);
			return curr;
		}
	}
}
