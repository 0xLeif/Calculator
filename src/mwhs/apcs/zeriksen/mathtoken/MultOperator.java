package mwhs.apcs.zeriksen.mathtoken;

public class MultOperator extends Operator{
	public MultOperator() {
		super('*',2);
	}

	@Override
	public Operand evaluate(Operand x, Operand y) {
		Operand mult = new Operand(x.getValue() * y.getValue());
		return mult;
	}
}
