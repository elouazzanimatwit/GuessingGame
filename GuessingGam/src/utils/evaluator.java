package utils;

import java.util.Stack;

public class evaluator {
	
	public static double evalPostFix(String postfix) throws Exception {
		Stack<Double> valueStack = new Stack<>();
		double result = 0;
		for(int i = 0; i < postfix.length(); i++) {
			char nextCh = postfix.charAt(i);
			if(Character.isDigit(nextCh)) {
				valueStack.push((double) (nextCh-'0'));
			} else if(isOperator(nextCh)) {
				double oper1 = valueStack.pop();
				double oper2 = valueStack.pop();
				result = operation(nextCh, oper1, oper2);
				valueStack.push(result);
			}
		}
		result = valueStack.pop();
		if(!valueStack.isEmpty()) {
			throw new Exception(); 
		}
		return result;
	}
	
	private static boolean isOperator(char ch) {
		return(ch == '-' || ch =='+' || ch == '*' || ch == '/' || ch == '^');
	}
	
	private static double operation(char op, double op1, double op2) {
		switch(op) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '*': return op1 * op2;
		case '/': return op1 / op2;
		case '^': return Math.pow(op1, op2);
		default: throw new IllegalArgumentException();
		}
	}
}
