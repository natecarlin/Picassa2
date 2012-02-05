package Expressions;

import java.util.List;
import model.RGBColor;

/**
 * MultExpression represents a multiplication of the constituent two color
 * expressions must be passed a list of size 2
 * 
 * @author ntc2
 * 
 */

public class MultExpression extends CommandExpression {
	static final String myCommand = "mult";

	public MultExpression(List<Expression> operands) {
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
		return new RGBColor(left.getRed() * right.getRed(), left.getGreen()
				* right.getGreen(), left.getBlue() * right.getBlue());
	}

	public static class MultFactory extends CommandFactory {

		public Expression parseExpression(String input) {
			return new MultExpression(this.findOperands(input));
		}

		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}
	}
}
