package dsa;
import java.util.*;
public class ArrayListDSA {
	public static void main (String args[]) {
		//indexing in ArrayList starts with 0
		//add takes O(n) since we need to change index of elements that occur after it
		//get takes O(1) since we know index location
		//set takes O(1) since we don't change index for set
		//remove takes O(n) since we need to change index of elements that occur after it
		//indexOf takes O(n) since it checks all elements to find given input in list
		//contains takes O(n) since it uses indexOf to perform it
		
		
		//constructor -> empty ArrayList
		ArrayList<Integer> list = new ArrayList<>(); 
		
		//when we put our ArrayList object in sysout, its .toString function returns a string of all elements in it.
		System.out.println(list);
		
		//adding elements at last
		list.add(1);
		list.add(2);
		list.add(5);
		System.out.println(list);
		
		//adding at index i
		list.add(2, 3);
		list.add(3, 4);
		System.out.println(list);
		
		// removing element at i index
		list.remove(3);
		System.out.println(list);
		
		// changing element at index i
		list.set(3, 4);
		System.out.println(list);
		
		//size of list = number of elements
		int size = list.size();
		System.out.println("size = "+size);
		
		//get element at an index i
		int ele = list.get(1);
		System.out.println(ele);
		
		//to find indexOf element in list
		int idx = list.indexOf(4);
		System.out.println("index of 4 is -> "+idx);
		
		// contains function uses code like indexOf to check if given input occurs in any index of list
		boolean contains = list.contains(5);
		System.out.println(contains);
	}
}
