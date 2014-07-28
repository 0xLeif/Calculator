package mwhs.apcs.zeriksen.mathtoken;

public class AddOperator extends Operator{
	public AddOperator() {
		super('+',1);
	}

	public Operand evaluate(Operand x, Operand y) {
		Operand add = new Operand(x.getValue() + y.getValue());
		return add;
	}
}
