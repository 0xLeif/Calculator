package mwhs.apcs.zeriksen.mathtoken;

public class DivOperator extends Operator{
	public DivOperator() {
		super('/',2);
	}

	@Override
	public Operand evaluate(Operand x, Operand y) {
		Operand div = new Operand(y.getValue() / x.getValue());
		return div;
	}
}
