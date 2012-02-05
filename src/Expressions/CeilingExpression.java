package Expressions;

import java.util.List;


import model.RGBColor;

public class CeilingExpression extends CommandExpression{
	static final String myCommand = "ceiling";

	CeilingExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return(myExpressions.size()==1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor input = myExpressions.get(0).evaluate(x, y);
		return new RGBColor(Math.ceil(input.getRed()),Math.ceil(input.getGreen()),Math.ceil(input.getBlue()));
	}
	
	public static class CeilingFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new CeilingExpression(this.findOperands(input));
		}
	}

}
