package dsa;

import java.util.*;

public class TreeSetCollections {
	public static void main(String args[]) {
//		TreeSet is basically an implementation of a self-balancing binary search tree like a Red-Black Tree.
//		Therefore operations like add, remove, and search takes O(log(N)) time.
//		The reason is that in a self-balancing tree, it is made sure that the height of the tree is always O(log(N)) for all the operations.
//		Therefore, this is considered as one of the most efficient data structures
//		in order to store the huge sorted data and perform operations on it.
//		However, operations like printing N elements in the sorted order take O(N) time.
		
//		TreeSet(Comparator): This constructor is used to build an empty TreeSet object in which
//		elements will need an external specification of the sorting order.
		
//		TreeSet(Collection): This constructor is used to build a TreeSet object containing all the elements
//		from the given collection in which elements will get stored in default natural sorting order.
//		In short, this constructor is used when any conversion is needed from any Collection object to TreeSet object.
		
		TreeSet<Integer> ts = new TreeSet<>();
		// ts.addAll(any_collection);
		ts.add(5);
		ts.add(3);
		ts.add(6);
		System.out.println(ts.ceiling(4)); // return same element if ceiling=current element passed.
		System.out.println(ts.ceiling(7)); // return null if no such element present
		System.out.println(ts.floor(4)); // return same element if floor=current element passed.
		System.out.println(ts.floor(2)); // return null if no such element present
		System.out.println("TS: "+ts); // to string gives list of all present ele in the collection
		//ts.clear(); // remove all elements
		//System.out.println(ts);
		
		
//		Shallow Copy stores the references of objects to the original memory address. Deep copy stores copies of the object's value.
//		Shallow Copy reflects changes made to the new/copied object in the original object.
//		Deep copy doesn't reflect changes made to the new/copied object in the original object
		TreeSet<Integer> newts = (TreeSet<Integer>) ts.clone();
		newts.remove(3);
		System.out.println("newTS : "+newts);
		System.out.println("does TS contain 3: "+ts.contains(3));
		System.out.println("does newTS contain 3: "+newts.contains(3));
		System.out.println("size of TS: "+ts.size());
		System.out.println("size of newTS: "+newts.size());
		
		System.out.println("ts: "+ts+": is TS empty? : "+ts.isEmpty());
		ts.clear();
		System.out.println("ts: "+ts+": is TS empty? : "+ts.isEmpty());
		
		System.out.println("\n\nIteration using iterator");
		Iterator<Integer> it = newts.iterator();
		while(it.hasNext()) {
			int curr = it.next();
			System.out.println(curr);
		}
	}
}