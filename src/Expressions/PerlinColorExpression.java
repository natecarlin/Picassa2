package Expressions;

import java.util.List;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorExpression extends CommandExpression{
	final static String myCommand = "PerlinColor";

	PerlinColorExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 2);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor left = myExpressions.get(0).evaluate(x, y);
		RGBColor right = myExpressions.get(1).evaluate(x, y);
		return PerlinNoise.colorNoise(left, right);
	}
	
	public static class PerlinColorFactory extends CommandFactory{

		@Override
		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

		@Override
		public Expression parseExpression(String input) {
			return new PerlinColorExpression(this.findOperands(input));
		}
		
	}

}
