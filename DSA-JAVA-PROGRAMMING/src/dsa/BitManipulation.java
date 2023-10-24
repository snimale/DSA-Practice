package dsa;

import java.util.Scanner;

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
		
		// be careful of how many times you shift, if u shift once, it points to second bit i.e 1st index for 0 indexing
		
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
		
		//toggle bit at ith location
		i = 1;
		mask = 1<<i;
		num = num^mask;
		System.out.println("toggled 1st index of num, result -> "+num);
		
		
		//count number of bits needed to change to convert a -> b
		//using XOR operation to locations of different bits, as they are the only ones that need to change for converting a -> b
		a = 4;
		b = 7;
		int aXORb = a^b;
		int count = 0;
		while(aXORb!=0) {
			aXORb=aXORb&(aXORb-1); // when we do a&(a-1), what we do is we remove the rightmost set bit from a, we do this till all bits gone.
			// thus, this method has O(n) complexity where n=number of set bits
			// beautiful algo think about it
			count+=1;
		}
		System.out.println(count+" bits need to be changed to convert "+a+" -> "+b);
		
		//divide a number by 2
		a=a>>2;
		//multiply a number by 2
		b=b<<2;
		
		// some properties of XOR
		int c = 5;
		int d = 5;
		c = c^c; // n^n = 0 
		d = d^0; // n^0 = n 
		System.out.println(c);
		System.out.println(d);
		
		// convert lower to higher and visa versa in ASCII
		char upper='A';
		char lower='a';
		char upper1=(char) (lower^' ');
		char lower1=(char) (upper^' '); // space=32
		System.out.println(lower1);
		System.out.println(upper1);
		
		// finding XOR of numbers from range 1 to n
		// think in binary, every binary num is generated from the LSB being changed
		System.out.print("Enter number n: ");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println();
		if(n%4==0) {
			// double pair i.e 1^1
			System.out.println(0);
		} else if(n%4==2) {
			// single pair left i.e 1 on XOR
			System.out.println(1);
		} else if(n%4==1) {
			// after reset to 0, 0^next = next
			System.out.println(n);
		} else {
			// here the last bit is 1(odd num) and single pair xor is 1
			System.out.println(n-1);
		}
		
		
		// finding XOR of numbers from range n1 to n2
		// to do this just find XOR for n1 and find XOR for n2 and do XOR of both result obtained
		// think logically, you are getting 0 if u xor same with same
		
		// finding 
	}

}
