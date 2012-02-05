package Expressions;

import java.util.List;

import model.RGBColor;

public class ClampExpression extends CommandExpression{
	final static String myCommand = "clamp";

	ClampExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		input.clamp();
		return input;
	}
	
	public static class ClampFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new ClampExpression(this.findOperands(input));
		}
		
	}

}
