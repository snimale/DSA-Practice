package easyQ;

import java.util.HashSet;


public class HashSetQuestions {
	public static void main(String args[]) {
		System.out.println("zzz");
	}
	
	public static HashSet<Integer> setUnion(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> union = new HashSet<>(set1.size()+set2.size());
		for(int e : set1) {
			union.add(e);
		}
		for(int e : set2) {
			union.add(e);
		}
		return union;
	}
	
	public static HashSet<Integer> setIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> intersection = new HashSet<>(Math.min(set1.size(), set2.size()));
		for (int e : set1) {
			if(set2.contains(e)) {
				intersection.add(e);
			}
		}
		return intersection;
		
	}
	
	public static int uniqueCount(int[] arr) {
		HashSet<Integer> uniqueElements = new HashSet<>(arr.length);
		for(int e : arr) {
			uniqueElements.add(e);
		}
		return uniqueElements.size();
	}
	
}
