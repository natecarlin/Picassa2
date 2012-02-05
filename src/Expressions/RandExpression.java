package Expressions;

import java.util.List;
import java.util.Random;

import model.RGBColor;

public class RandExpression extends CommandExpression{
	static final String myCommand = "random";
	static Random myRandom;
	public RGBColor myColor;

	
	RandExpression(List<Expression> operands) {
		super(operands);
		myRandom = new Random();
		myColor = new RGBColor((myRandom.nextFloat()*2)-1,(myRandom.nextFloat()*2)-1, (myRandom.nextFloat()*2)-1);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size()==0); 
	}
	

	@Override
	public RGBColor operate(double x, double y) {
		return myColor;
	}
	
	public static class RandomFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new RandExpression(this.findOperands(input));
		}
		
	}

}
