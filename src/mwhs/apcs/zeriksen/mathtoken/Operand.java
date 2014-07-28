package mwhs.apcs.zeriksen.mathtoken;

public class Operand implements MathToken{
	private double value;
	
	public Operand(Double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public String toString() {
		String str = "" + value;
		return str;
	}
}
