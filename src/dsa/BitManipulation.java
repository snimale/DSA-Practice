package dsa;


public class BitManipulation {
	public static void main(String args[]) {
		
		//swapping two integers with bit manipulation
		int a = 5;
		int b = 2;
		System.out.print(a+", "+b+" -> ");
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+", "+b);
		
		
		//finding odd/even using bit manipulation
		int num = 5;
		if ((num&1)==0) {
			System.out.println(num+" is even");
		} else {
			System.out.println(num+" is odd");
		}
		
		//getting bit at i index, where i indexing starts from 0 at rightmost bit to leftmost
		int i = 2;
		int mask = 1<<i;
		if (((num&mask)==0)) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
		
		//setting bit at i index, setting means 0 -> 1 or 1 -> 1, i starts from 0 at rightmost bit
		i = 1;
		mask = 1<<i;
		num = num|mask;
		System.out.println("set 1st index of num, result -> "+num);
		
		//clearing bit at i index, clearing means 0 -> 0 or 1 -> 1, i starts from 0 at rightmost bit
		i = 1;
		mask = ~(1<<i);
		num = num&mask;
		System.out.println("cleared 1st index of num, result -> "+num);
		
		//count number of bits needed to change to convert a -> b
		//using XOR operation to locations of different bits, as they are the only ones that need to change for converting a -> b
		a = 4;
		b = 7;
		int aXORb = a^b;
		int count = 0;
		while(aXORb!=0) {
			aXORb=aXORb&(aXORb-1);
			count+=1;
		}
		System.out.println(count+" many bits need to be changed to convert "+a+" -> "+b);
	
	}

}
