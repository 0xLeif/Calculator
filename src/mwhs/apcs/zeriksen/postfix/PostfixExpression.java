package mwhs.apcs.zeriksen.postfix;

import java.util.List;
import mwhs.apcs.zeriksen.mathtoken.MathToken;
import mwhs.apcs.zeriksen.mathtoken.Operand;
import mwhs.apcs.zeriksen.mathtoken.Operator;

public class PostfixExpression {
	private List<MathToken> tokens;

	public PostfixExpression(List<MathToken> tokens) {
		this.tokens = tokens;
	}

	public double evaluate() {
		Operator operator;
		MyStack<Operand> stack = new MyStack<Operand>();
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Operator) {
				operator = (Operator) tokens.get(i);
				stack.push(operator.evaluate(stack.pop(), stack.pop()));
			}else{
				stack.push((Operand) tokens.get(i));
			}
		}
		return stack.pop().getValue();
	}

}
