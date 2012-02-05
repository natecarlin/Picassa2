package Expressions;

import java.util.List;

import model.RGBColor;

public class AbsExpression extends CommandExpression{
	final static String myCommand = "abs";

	AbsExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x,y);
		return new RGBColor(Math.abs(input.getRed()),Math.abs(input.getGreen()),Math.abs(input.getBlue()));
	}
	
	public static class AbsFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new AbsExpression(this.findOperands(input));
		}
		
	}

}
