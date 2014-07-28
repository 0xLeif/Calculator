package mwhs.apcs.zeriksen.test;

import mwhs.apcs.zeriksen.postfix.InfixToPostfix;
import mwhs.apcs.zeriksen.postfix.PostfixExpression;

public class Test {
	public static void main(String[] args) {
		InfixToPostfix infix = new InfixToPostfix("(7 + 2 + 6 - 7 / 7 * 8) / (6 * 8 / 2 + 4 - 3)"); 
		PostfixExpression postfix = new PostfixExpression(infix.toPost());
		System.out.println(postfix.evaluate());
	}
}
