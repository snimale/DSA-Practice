package hardQ;
import java.util.*;

public class InfixPostfixPrefix {
	private static Deque<Character> stack = new ArrayDeque<>();
	
	public static void main(String args[]) {
		// TEST CASE - K+L-M*N+(A^B)*C/D-P*Q
		// TEST CASE2 = - (p*q^R)/a*C-D^e
		// Q) Convert a inFix expression into postFix expression
		Scanner sc = new Scanner(System.in);
		String InfixExpression = sc.nextLine();
		sc.close();
		String postfixExpression = infixToPostfix(InfixExpression);
		String prefixExpression = infixToPrefix(InfixExpression);
		System.out.println("Postfix Expression : " + postfixExpression);
		System.out.println("Prefix Expression : " + prefixExpression);
	}
	
	public static String infixToPrefix(String infixExpression) {
		StringBuilder prefixExpression = new StringBuilder();
		stack.clear();
		for(int i=infixExpression.length()-1; i>=0; i--) {
			
			char curr = infixExpression.charAt(i);
			if(isOperand(curr)) prefixExpression.append(curr);
			else {
				if(stack.isEmpty()) stack.push(curr);
				else {
					if(curr==')') stack.push(curr);
					else if(curr=='(') {
						while(stack.peek()!=')') prefixExpression.append(stack.pop());
						stack.pop();
					}
					else if(priority(curr)>priority(stack.peek())) stack.push(curr);
					else {
						while(!stack.isEmpty()) {
							if(priority(stack.peek())>priority(curr)) {
								prefixExpression.append(stack.pop());
								
							}
							else if(priority(stack.peek()) == priority(curr)) {
								if(curr=='^') prefixExpression.append(stack.pop());
								else break;
							} else break;
						}
						stack.push(curr);
					}
				}
			}	
		}
		while(!stack.isEmpty()) prefixExpression.append(stack.pop());
		for(int i=0; i<prefixExpression.length()/2; i++) {
			char temp = prefixExpression.charAt(i);
			prefixExpression.setCharAt(i, prefixExpression.charAt(prefixExpression.length()-i-1));
			prefixExpression.setCharAt(prefixExpression.length()-i-1,  temp);
		}
		return prefixExpression.toString();
	}
	
	public static String infixToPostfix(String infixExpression) {
		StringBuilder postfixExpression = new StringBuilder();
		stack.clear();
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
		return postfixExpression.toString();
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
