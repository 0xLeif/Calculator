package mwhs.apcs.zeriksen.mathtoken;

public abstract class Operator implements MathToken{
	//Same as a class but you can have unimplemented methods
	//Cant create a new Operator
	private char symbol;
	private int presadance;
	
	public Operator(char symbol, int presadance){
		this.symbol = symbol;
		this.presadance = presadance;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public abstract Operand evaluate(Operand x, Operand y);
	
	public String toString() {
		String str = "" + symbol;
		return str;
	}

	public int getPresadance() {
		return presadance;
	}

}
