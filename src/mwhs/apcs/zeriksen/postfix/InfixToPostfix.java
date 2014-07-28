package mwhs.apcs.zeriksen.postfix;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mwhs.apcs.zeriksen.mathtoken.AddOperator;
import mwhs.apcs.zeriksen.mathtoken.DivOperator;
import mwhs.apcs.zeriksen.mathtoken.LeftPeran;
import mwhs.apcs.zeriksen.mathtoken.MathToken;
import mwhs.apcs.zeriksen.mathtoken.MultOperator;
import mwhs.apcs.zeriksen.mathtoken.Operand;
import mwhs.apcs.zeriksen.mathtoken.Operator;
import mwhs.apcs.zeriksen.mathtoken.RightPeran;
import mwhs.apcs.zeriksen.mathtoken.SubOperator;

public class InfixToPostfix {
	private List<MathToken> tokens;

	public InfixToPostfix(String infix) {
		tokens = new ArrayList<MathToken>();
		MyStack<String> stack = new MyStack<String>();
		MyStack<MathToken> stack2 = new MyStack<MathToken>();
		infix = infix.replaceAll("\\s", "");
		String str = "";
		InputStream stream = new ByteArrayInputStream(infix.getBytes());
		Scanner in = new Scanner(stream);

		for (int i = 0; i < infix.length(); i++) {
			if (infix.substring(i, i + 1).equals("0")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("1")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("2")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("3")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("4")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("5")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("6")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("7")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("8")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals("9")) {
				str += infix.substring(i, i + 1);
			} else if (infix.substring(i, i + 1).equals(".")) {
				str += infix.substring(i, i + 1);
			} else {
				if (str.length() > 0)
					stack.push(str);
				stack.push(infix.substring(i, i + 1));
				str = "";
			}
			if (i == infix.length() - 1) {
				if (str.length() > 0)
					stack.push(str);
			}
		}
		//System.out.println(stack);
		while (true) {
			if (stack.isEmpty())
				break;
			if (stack.peek().contains("+")) {
				AddOperator a = new AddOperator();
				stack2.push(a);
				stack.pop();
			} else if (stack.peek().contains("-")) {
				SubOperator s = new SubOperator();
				stack2.push(s);
				stack.pop();
			} else if (stack.peek().contains("*")) {
				MultOperator m = new MultOperator();
				stack2.push(m);
				stack.pop();
			} else if (stack.peek().contains("/")) {
				DivOperator d = new DivOperator();
				stack2.push(d);
				stack.pop();
			} else if (stack.peek().contains("(")) {
				LeftPeran l = new LeftPeran();
				stack2.push(l);
				stack.pop();
			} else if (stack.peek().contains(")")) {
				RightPeran r = new RightPeran();
				stack2.push(r);
				stack.pop();
			} else {
				Operand o = new Operand(Double.parseDouble(stack.pop()));
				stack2.push(o);
			}
			
		}
		while (true) {
			if (stack2.isEmpty())
				break;
			tokens.add(stack2.pop());
		}
	}

	public List<MathToken> toPost() {
		int count = 0;
		MyStack<Operator> stack = new MyStack<Operator>();
		List<MathToken> tokens2 = new ArrayList<MathToken>();
		//System.out.println(tokens);
		for (MathToken tok : tokens) {
			if (tok instanceof Operand) {
				tokens2.add(tok);
			} else if (stack.isEmpty() == true) {
				stack.push((Operator) tok);
			} else if (tok instanceof DivOperator
					|| tok instanceof MultOperator) {
				if (stack.peek().getPresadance() == 2) {
					tokens2.add(stack.pop());
					stack.push((Operator) tok);
				} else {
					stack.push((Operator) tok);
				}
			} else if (tok instanceof AddOperator || tok instanceof SubOperator) {
				if (stack.peek().getPresadance() == 1) {
					tokens2.add(stack.pop());
					stack.push((Operator) tok);
				} else if (stack.peek().getPresadance() == 2) {
					tokens2.add(stack.pop());
					stack.push((Operator) tok);
				} else {
					stack.push((Operator) tok);
				}
			}
			if (tok instanceof LeftPeran) {
				stack.push((Operator) tok);
				count++;
			}
			if (tok instanceof RightPeran) {
				while (true) {
					if (stack.peek() instanceof LeftPeran) {
						if (count == 2) {
							stack.pop();
							tokens2.add(stack.pop());
							count = 0;
						}
						break;
					}
					tokens2.add(stack.pop());
					if (tok instanceof Operand) {
						break;
					}
				}
			}
		}
		while (stack.isEmpty() != true) {
			if (stack.peek() instanceof LeftPeran) {
				stack.pop();
			} else {
				tokens2.add(stack.pop());
			}
		}
		//System.out.println(tokens2);
		return tokens2;
	}
}