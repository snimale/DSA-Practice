package dsa;

public class Mathematics {
	public static void main(String args[]) {
		
	}
	
	static int getFactorial(int n) {
		if (n==0 | n==1) {
			return 1;
		}
		return n * getFactorial(n-1);
	}
	
	static int reverseInteger (int n) {
		int currDigit = n%10;
		int reverseNumber = 0;
		while (currDigit!=0 | n/10 != 0) {
			reverseNumber *= 10;
			reverseNumber += currDigit;
			n /= 10;
			currDigit = n%10;
		}
		return reverseNumber;
	}

}
