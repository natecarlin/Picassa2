package Expressions;

import java.util.List;
import model.RGBColor;

/**
 * ExponentExpression represents a exponentiation of the constituent two color
 * expressions must be passed a list of size 2
 * 
 * @author ntc2
 * 
 */

public class ExponentExpression extends CommandExpression {
	static final String myCommand = "exp";

	public ExponentExpression(List<Expression> operands) {
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
		return new RGBColor(Math.pow(left.getRed(), right.getRed()), Math.pow(
				left.getGreen(), right.getGreen()), Math.pow(left.getBlue(),
				right.getBlue()));
	}

	public static class ExpFactory extends CommandFactory {

		public Expression parseExpression(String input) {
			return new ExponentExpression(this.findOperands(input));
		}

		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}
	}
}
