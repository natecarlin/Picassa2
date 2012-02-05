package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.RGBColor;

/**
 * VarExpression represents a color gradient along one of the axes. x represents
 * a left to right gradient y represents a top to bottom gradient should be
 * passed either 'x' or 'y'
 * 
 * @author ntc2
 * 
 */

public class AxisExpression extends Expression {
	char myVar;
	private static final Pattern AXIS_REGEX = Pattern.compile("[xy]");

	public AxisExpression(char input) {
		myVar = input;
	}
	
	@Override
	public boolean isVariable(){
		return false;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		if (myVar == 'x') {
			return new RGBColor(x, x, x);
		} else if (myVar == 'y') {
			return new RGBColor(y, y, y);
		}
		return null;
	}

	public static class AxisFactory extends ExpressionFactory {

		public boolean isThisThing(String input) {
			Matcher axisMatcher = AXIS_REGEX.matcher(input);
			return axisMatcher.lookingAt();
		}

		@Override
		public Expression parseExpression(String input) {
			if (input.charAt(0) == 'x') {
				return new AxisExpression('x');
			} else
				return new AxisExpression('y');
		}

	}

}