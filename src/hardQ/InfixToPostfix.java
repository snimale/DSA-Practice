package hardQ;
import java.util.*;

public class InfixToPostfix {
	private static Deque<Character> stack = new ArrayDeque<>();
	
	public static void main(String args[]) {
		// TEST CASE - K+L-M*N+(A^B)*C/D-P*Q
		// Q) Convert a inFix expression into postFix expression
		Scanner sc = new Scanner(System.in);
		String infixExpression = sc.nextLine();
		sc.close();
		StringBuilder postfixExpression = new StringBuilder();
		for(int i=0; i<infixExpression.length(); i++) {
			char curr = infixExpression.charAt(i);
			if(isOperand(curr)) postfixExpression.append(curr);
			else {
				if(stack.isEmpty()) stack.push(curr);
				else {
					if(curr=='(') stack.push(curr);
					else if(curr==')') {
						while(stack.peek()!='(') postfixExpression.append(stack.pop());
						stack.pop();
					}
					else if(priority(stack.peek()) < priority(curr)) stack.push(curr);
					else {
						while(!stack.isEmpty()) {
							if(priority(stack.peek()) > priority(curr)) postfixExpression.append(stack.pop());
							else if(priority(stack.peek()) == priority(curr)) {
								if(curr!='^') postfixExpression.append(stack.pop());
								else break;
							}
							else if(priority(stack.peek()) < priority(curr)) break;
						}
						stack.push(curr);
					}
				}
			}
		}
		while(!stack.isEmpty()) postfixExpression.append(stack.pop());
		System.out.println(postfixExpression.toString());
	}
	
	private static boolean isOperand(char curr) {
		if(curr!='+' && curr!='-' && curr!='*' && curr!='/' && curr!='(' && curr!=')' && curr!='^') return true;
		return false;
	}
	
	private static int priority(char curr) {
		if(curr == '+' || curr == '-') return 0;
		else if(curr == '*' || curr == '/') return 1;
		else if(curr == '^') return 2;
		else return -1;	
	}
}
