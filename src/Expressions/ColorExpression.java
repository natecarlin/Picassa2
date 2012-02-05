package Expressions;

import java.util.List;

import model.RGBColor;

/**
 * ColorExpression represents a combination of the red, green, and blue parts of
 * its constituents in order must be passed a list of size 3
 * 
 * @author ntc2
 * 
 */

public class ColorExpression extends CommandExpression {
	static final String myCommand = "color";

	public ColorExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 3);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor first = myExpressions.get(0).evaluate(x, y);
		RGBColor second = myExpressions.get(1).evaluate(x, y);
		RGBColor third = myExpressions.get(2).evaluate(x, y);
		return new RGBColor(first.getRed(), second.getGreen(), third.getBlue());
	}

	public static class ColorFactory extends CommandFactory {

		@Override
		public Expression parseExpression(String input) {
			return new ColorExpression(this.findOperands(input));
		}

		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}

	}
}
