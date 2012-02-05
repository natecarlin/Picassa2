package Expressions;

import java.util.List;

import model.RGBColor;

public class TanExpression extends CommandExpression{
	final static String myCommand = "tan";

	TanExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		return new RGBColor(Math.tan(input.getRed()),Math.tan(input.getGreen()),Math.tan(input.getBlue()));
	}
	
	public static class TanFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new TanExpression(this.findOperands(input));
		}
		
	}

}
