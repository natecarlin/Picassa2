package Expressions;

import java.util.List;
import model.RGBColor;

/**
 * NegExpression represents an inversion of the constituent two color
 * expressions must be passed a list of size 1
 * 
 * @author ntc2
 * 
 */

public class NegExpression extends CommandExpression {
	static final String myCommand = "neg";

	public NegExpression(List<Expression> operands) {
		super(operands);
	}

	@Override
	public boolean correctParams() {
		return (myExpressions.size() == 1);
	}

	@Override
	public RGBColor operate(double x, double y) {
		RGBColor left = myExpressions.get(0).evaluate(x, y);
		return new RGBColor(-left.getRed(), -left.getGreen(), -left.getBlue());
	}

	public static class NegFactory extends CommandFactory {

		public Expression parseExpression(String input) {
			return new NegExpression(this.findOperands(input));
		}

		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}
	}
}
