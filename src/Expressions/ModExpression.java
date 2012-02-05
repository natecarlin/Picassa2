package Expressions;

import java.util.List;
import model.RGBColor;

/**
 * ModExpression represents the modular relation between the constituent two
 * color expressions must be passed a list of size 2
 * 
 * @author ntc2
 * 
 */

public class ModExpression extends CommandExpression {
	static final String myCommand = "mod";

	public ModExpression(List<Expression> operands) {
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
		return new RGBColor(left.getRed() % right.getRed(), left.getGreen()
				% right.getGreen(), left.getBlue() % right.getBlue());
	}

	public static class ModFactory extends CommandFactory {

		public Expression parseExpression(String input) {
			return new ModExpression(this.findOperands(input));
		}

		public boolean isThisThing(String input) {
			return (findName(input).equals(myCommand));
		}
	}
}
