package mwhs.apcs.zeriksen.mathtoken;

public class SubOperator extends Operator{
	public SubOperator() {
		super('-',1);
	}

	@Override
	public Operand evaluate(Operand x, Operand y) {
		Operand sub = new Operand(y.getValue() - x.getValue());
		return sub;
	}
}
