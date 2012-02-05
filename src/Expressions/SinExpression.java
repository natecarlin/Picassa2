package Expressions;

import java.util.List;

import model.RGBColor;

public class SinExpression extends CommandExpression{
	final static String myCommand = "sin";

	SinExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		return new RGBColor(Math.sin(input.getRed()),Math.sin(input.getGreen()),Math.sin(input.getBlue()));
	}
	
	public static class SinFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new SinExpression(this.findOperands(input));
		}
		
	}

}

