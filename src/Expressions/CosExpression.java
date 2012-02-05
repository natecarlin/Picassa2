package Expressions;

import java.util.List;

import model.RGBColor;

public class CosExpression extends CommandExpression{
	final static String myCommand = "cos";

	CosExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		return new RGBColor(Math.cos(input.getRed()),Math.cos(input.getGreen()),Math.cos(input.getBlue()));
	}
	
	public static class CosFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new CosExpression(this.findOperands(input));
		}
		
	}

}
