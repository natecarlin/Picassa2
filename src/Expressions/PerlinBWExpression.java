package Expressions;

import java.util.List;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBWExpression extends CommandExpression{
	final static String myCommand = "perlinBW";

	PerlinBWExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 2);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor left = myExpressions.get(0).evaluate(x, y);
		RGBColor right = myExpressions.get(0).evaluate(x, y);
		return PerlinNoise.greyNoise(left, right);
	}
	
	public static class PerlinBWFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new PerlinBWExpression(this.findOperands(input));
		}
		
	}

}
